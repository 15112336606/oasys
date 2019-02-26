package com.oa.user.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.common.vo.PageObject;
import com.oa.user.entity.UserUserInfo;
import com.oa.user.service.UserUserInfoService;
import com.oa.user.vo.UserUserDeptDutyInfo;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	UserUserInfoService userUserInfoService;
	
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult findPageObjects(String username,int pageCurrent){
		PageObject<UserUserDeptDutyInfo> po = userUserInfoService.findPageObjects(username, pageCurrent);
		return new JsonResult(po);
	}
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/user_edit";
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(UserUserInfo user,Integer[] purview,String cfgpassword){
		userUserInfoService.doSaveObject(user, purview,cfgpassword);
		return new JsonResult("save Ok");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		Map<String, Object> map = userUserInfoService.doFindObjectById(id);
		return new JsonResult(map);
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(UserUserInfo user,Integer[] purview){
		userUserInfoService.doUpdateObject(user, purview);
		return new JsonResult("update ok");
	}
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid,String modifiedUser){
		modifiedUser="admin";
		userUserInfoService.doUpdateValidById(id, valid, modifiedUser);
		
		return new JsonResult("update ok");
	}
	
	@ResponseBody
	@RequestMapping("UpdatePassword")
	public JsonResult UpdatePassword(String password,String newPassword,String cfgPassword){
		userUserInfoService.doUpdatePassword(password, newPassword, cfgPassword);
		return new JsonResult("修改密码成功");
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.对用户信息进行封装
		UsernamePasswordToken token=new UsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		//2.提交用户信息(交给shiro框架进行认证)
		Subject subject=SecurityUtils.getSubject();
		subject.login(token);
		//token会传递给securityManager
		//securityManager会将token传递给认证管理器
		return new JsonResult("login ok");
	}
}

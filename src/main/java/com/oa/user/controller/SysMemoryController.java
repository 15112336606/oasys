package com.oa.user.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.user.entity.UserMemory;
import com.oa.user.entity.UserUserInfo;
import com.oa.user.service.UserMemoryService;
import com.oa.user.vo.Memory;

@Controller
@RequestMapping("/memory/")
public class SysMemoryController {
	@Autowired
	UserMemoryService userMemoryService;
	@RequestMapping("insertObject")
	@ResponseBody
	public JsonResult insertObject(UserMemory memory){
		//后期根据登录id进行拦截修改
		UserUserInfo user=(UserUserInfo)SecurityUtils.getSubject().getPrincipal();
		memory.setUsername(user.getUsername());
		userMemoryService.insertObject(memory);
		return new JsonResult("ok");
	}
	@ResponseBody
	@RequestMapping("findObjects")
	public JsonResult findObjects(String username){
		UserUserInfo user=(UserUserInfo)SecurityUtils.getSubject().getPrincipal();
		username=user.getUsername();
		List<Memory> list = userMemoryService.findObjects(username);
		return new JsonResult(list);
	}
	@RequestMapping("deleteObjects")
	@ResponseBody
	public JsonResult deleteObjects(String username,String date) throws Exception{
		UserUserInfo user=(UserUserInfo)SecurityUtils.getSubject().getPrincipal();
		username=user.getUsername();
		userMemoryService.deleteObjects(username, date);
		return new JsonResult("delete ok");
	}
}

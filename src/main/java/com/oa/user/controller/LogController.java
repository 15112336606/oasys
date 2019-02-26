package com.oa.user.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.common.vo.PageObject;
import com.oa.user.entity.LogComment;
import com.oa.user.entity.LogInfo;
import com.oa.user.service.UserLogService;

@RequestMapping("log/")
@Controller
public class LogController {
	@Autowired
	private UserLogService userLogService;
	
	@RequestMapping("doLogListUI")
	public String doLogUI(){
		return "sys/log_list";
	}
	
	@RequestMapping("doLogEditUI")
	public String doLogEditUI(){
		return"sys/log_edit";
	}
	
	@ResponseBody
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username,
										Integer pageCurrent){
		PageObject<LogInfo> po = userLogService.findPageObject(username, pageCurrent);
		return new JsonResult(po);
	}
	
	@RequestMapping("doFindQureyObjectById")
	@ResponseBody
	public JsonResult doFindQureyObjectById(Integer id){
		return new JsonResult(userLogService.doFindQureyObjectById(id));
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		return new JsonResult(userLogService.findObjectById(id));
	}
	
	@ResponseBody
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(LogInfo userLog){
		userLogService.insertObject(userLog);
		return new JsonResult("日志添加成功!");
	}
	
	@ResponseBody
	@RequestMapping("doSaveComment")
	public JsonResult doSaveComment(LogComment lc){
		userLogService.saveComment(lc);
		return new JsonResult("评论成功!");
	}
	
	@ResponseBody
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(LogInfo userLog){
		userLogService.updateObject(userLog);
		return new JsonResult("修改成功!");
	}
	
	@RequestMapping("doLogQueryUI")
	public String doLogQueryUI(){
		return "sys/log_query";
	}
	
	@ResponseBody
	@RequestMapping("doDeleteObjects")
	public JsonResult doDeleteObjects(Integer... ids){
		System.out.println(Arrays.toString(ids));
		userLogService.deleteObjectsByIds(ids);
		return new JsonResult("删除成功!");
	}
	
	
}

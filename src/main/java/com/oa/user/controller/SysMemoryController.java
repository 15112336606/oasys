package com.oa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.user.entity.UserMemory;
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
		memory.setUsername("admin");
		userMemoryService.insertObject(memory);
		return new JsonResult("ok");
	}
	@ResponseBody
	@RequestMapping("findObjects")
	public JsonResult findObjects(String username){
		username="admin";
		List<Memory> list = userMemoryService.findObjects(username);
		for(Memory l:list)System.out.println(l);
		return new JsonResult(list);
	}
}

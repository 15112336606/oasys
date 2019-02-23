package com.oa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.user.service.UserDeptService;

@Controller
@RequestMapping("/dept/")
public class SysDeptController {
	@Autowired
	UserDeptService userDeptService;
	
	@ResponseBody
	@RequestMapping("findDeptZtreeNode")
	public JsonResult findDeptZtreeNode(){
		return new JsonResult(userDeptService.findDeptZtreeNode());
	}
}

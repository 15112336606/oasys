package com.oa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.user.service.UserDutyService;

@Controller
@RequestMapping("/duty/")
public class SysDutyController {
	@Autowired
	UserDutyService userDutyService;
	
	@RequestMapping("findDutyZtreeNode")
	@ResponseBody
	public JsonResult findDutyZtreeNode(){
		return new JsonResult(userDutyService.findDutyZtreeNode());
	}
}

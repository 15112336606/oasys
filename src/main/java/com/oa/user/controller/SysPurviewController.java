package com.oa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;
import com.oa.user.service.UserPurviewService;

@Controller
@RequestMapping("/purview/")
public class SysPurviewController {
	@Autowired
	UserPurviewService userPurviewService;
	
	@ResponseBody
	@RequestMapping("findPurviews")
	public JsonResult findPurviews(){
		return new JsonResult(userPurviewService.findPurviews());
	}
}

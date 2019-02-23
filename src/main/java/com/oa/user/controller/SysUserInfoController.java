package com.oa.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/userinfo/")
public class SysUserInfoController {
	
	@RequestMapping("doFindUserInfoListUI")
	public String doFindUserInfoListUI(){
		return "sys/userinfo_list";
	}

}

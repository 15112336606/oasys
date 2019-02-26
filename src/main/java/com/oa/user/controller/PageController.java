package com.oa.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";
	}
	@RequestMapping("doFindCalender")
	public String doFindCalender(){
		return "sys/wnl";
	}
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
	@RequestMapping("doUpdatePwd")
	public String doUpdatePwd(){
		return "sys/pwd_edit";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
			return "login";
	}
}

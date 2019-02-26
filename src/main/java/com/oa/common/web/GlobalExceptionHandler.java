package com.oa.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.vo.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e){
		e.printStackTrace();
		JsonResult r=new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException){
			r.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException){
			r.setMessage("账户被锁定");
		}else if(e instanceof CredentialsException){
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException){
			r.setMessage("没有此操作权限");
		}else{
			r.setMessage("认证或授权失败");
		}
		return r;
		
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}

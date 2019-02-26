package com.oa.user.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 通过集成实现代码复用
 * 1.共性写到父类
 * 2.特性写到子类
 * @author UID
 *
 */
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6052101108571661841L;
	//创建时间
	private Date createdTime;
	//修改时间
	private Date modifiedTime;
	//创建用户
	private String createdUser;
	//修改用户
	private String modifiedUser;
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	
}

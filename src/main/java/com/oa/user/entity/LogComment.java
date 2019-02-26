package com.oa.user.entity;

import java.io.Serializable;
import java.util.Date;

public class LogComment implements Serializable{

	private static final long serialVersionUID = 6563325767035670327L;
	
	private Integer id;
	private Integer logid;
	private String commentcontent;
	private Date createdTime;
	private Date modifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
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
	@Override
	public String toString() {
		return "LogComment [id=" + id + ", logid=" + logid + ", commentcontent=" + commentcontent + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + "]";
	}
	
}

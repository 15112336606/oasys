package com.oa.user.entity;

import java.io.Serializable;
import java.util.Date;

public class UserMemory implements Serializable{
	private static final long serialVersionUID = 5198826740998493519L;
	private Integer id;
	private String username;
	private Date start;
	private Date end;
	private String title;
	private String backgroundColor;
	private String borderColor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	@Override
	public String toString() {
		return "UserMemory [id=" + id + ", username=" + username + ", start=" + start + ", end=" + end + ", title=" + title
				+ ", backgroundColor=" + backgroundColor + ", borderColor=" + borderColor + "]";
	}

}

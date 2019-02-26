package com.oa.user.vo;

import java.io.Serializable;
import java.util.Date;

public class Memory implements Serializable{
	private static final long serialVersionUID = 986838072933819205L;
	private String title;
	private Date start;
	private Date end;
	private String backgroundColor;
	private String borderColor;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "Memory [title=" + title + ", start=" + start + ", end=" + end + ", backgroundColor=" + backgroundColor
				+ ", borderColor=" + borderColor + "]";
	}

}

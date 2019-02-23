package com.oa.common.vo;

import java.io.Serializable;

public class DutyNode implements Serializable{
	private static final long serialVersionUID = -4889726963841395256L;
	private int ID;
	private String dutyname;
	private String name;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDutyname() {
		return dutyname;
	}
	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
	@Override
	public String toString() {
		return "DutyNode [ID=" + ID + ", dutyname=" + dutyname + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

package com.oa.common.vo;

import java.io.Serializable;

public class DeptNode implements Serializable{
	private static final long serialVersionUID = 128369241169547240L;
	private int ID;
	private String department;
	private String name;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "DeptNode [ID=" + ID + ", department=" + department + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

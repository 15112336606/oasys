package com.oa.user.entity;

import java.io.Serializable;

public class UserDepartment implements Serializable{
	private static final long serialVersionUID = -2525711138152360896L;
private Integer ID;
private String department;
public Integer getID() {
	return ID;
}
public void setID(Integer iD) {
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
	return "UserDepartment [ID=" + ID + ", department=" + department + "]";
}

}

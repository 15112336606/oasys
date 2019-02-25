package com.oa.user.entity;

import java.io.Serializable;

public class UserDuty  implements Serializable{
	private static final long serialVersionUID = 8281329433963935107L;
private Integer ID;
private String dutyname;
private Integer grade;
private Integer purviewstr;
public Integer getID() {
	return ID;
}
public void setID(Integer iD) {
	ID = iD;
}
public String getDutyname() {
	return dutyname;
}
public void setDutyname(String dutyname) {
	this.dutyname = dutyname;
}
public Integer getGrade() {
	return grade;
}
public void setGrade(Integer grade) {
	this.grade = grade;
}
public Integer getPurviewstr() {
	return purviewstr;
}
public void setPurviewstr(Integer purviewstr) {
	this.purviewstr = purviewstr;
}

}

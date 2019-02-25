package com.oa.user.vo;
/**
 * 此vo对象封装采用部门名称和职务名称替换表中部门id和职务id的数据信息
 */
import java.io.Serializable;
import java.util.Date;

import com.oa.user.entity.UserDepartment;
import com.oa.user.entity.UserDuty;

public class UserUserDeptDutyInfo implements Serializable{
	private static final long serialVersionUID = 6047300312907787019L;
private Integer id;
private String username;//用户名
private String password;//密码
private String salt;//盐值
private Integer valid=1;//状态 默认启用=1,禁用=0;
private Integer basicId;//对应的基本信息id
private UserDepartment dept;//对应的部门
private UserDuty duty;//对应的职务
private Date createdTime;//用户创建时间
private Date modifiedTime;//用户修改时间
private String createdUser;//操作者
private String modifiedUser;//修改者
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSalt() {
	return salt;
}
public void setSalt(String salt) {
	this.salt = salt;
}
public Integer getValid() {
	return valid;
}
public void setValid(Integer valid) {
	this.valid = valid;
}
public Integer getBasicId() {
	return basicId;
}
public void setBasicId(Integer basicId) {
	this.basicId = basicId;
}
public UserDepartment getDept() {
	return dept;
}
public void setDept(UserDepartment dept) {
	this.dept = dept;
}
public UserDuty getDuty() {
	return duty;
}
public void setDuty(UserDuty duty) {
	this.duty = duty;
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
@Override
public String toString() {
	return "UserUserDeptDutyInfo [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
			+ ", valid=" + valid + ", basicId=" + basicId + ", dept=" + dept + ", duty=" + duty + ", createdTime="
			+ createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser="
			+ modifiedUser + "]";
}


}

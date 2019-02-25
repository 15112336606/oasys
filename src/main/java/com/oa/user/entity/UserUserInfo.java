package com.oa.user.entity;
/**
 * 此entity对象封装userinfo表信息
 */
import java.io.Serializable;
import java.util.Date;

public class UserUserInfo implements Serializable{
	private static final long serialVersionUID = -1416281299933077923L;
private Integer id;
private String username;//用户名
private String password;//密码
private String salt;//盐值
private Integer valid=1;//状态 默认启用=1,禁用=0;
private Integer basicId=null;//对应的基本信息id
private Integer deptId;//对应的部门id
private Integer dutyId;//对应的职务id
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
public Integer getDeptId() {
	return deptId;
}
public void setDeptId(Integer deptId) {
	this.deptId = deptId;
}
public Integer getDutyId() {
	return dutyId;
}
public void setDutyId(Integer dutyId) {
	this.dutyId = dutyId;
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
	return "UserUserInfo [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
			+ ", valid=" + valid + ", basicId=" + basicId + ", deptId=" + deptId + ", dutyId=" + dutyId
			+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
			+ ", modifiedUser=" + modifiedUser + "]";
}


}

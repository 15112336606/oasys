package com.oa.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oa.user.entity.UserUserInfo;
import com.oa.user.vo.UserUserDeptDutyInfo;

public interface UserUserInfoDao {
	//根据用户名或者部门id或者职务id查找记录条数
	int getRowCount(@Param("username")String username);
	
	
	//根据用户名或者部门id查找页面信息
	List<UserUserDeptDutyInfo> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	//添加User
	int doSaveObject(UserUserInfo user);
	
	//通过用户名查找是否已存在
	int findExistObject(String username);
	
	//通过用户id查找用户信息
	UserUserDeptDutyInfo findObject(Integer id);
	
	//修改用户信息
	int updateObject(UserUserInfo user);
	
	//修改权限
	int updateValidById(@Param("id")Integer id,@Param("valid")Integer valid,@Param("modifiedUser")String modifiedUser);
	
	//修改密码
	int updatePassword(@Param("username")String username,@Param("salt")String salt,@Param("password")String password);
}

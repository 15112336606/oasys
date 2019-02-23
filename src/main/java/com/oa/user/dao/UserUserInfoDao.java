package com.oa.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oa.user.vo.UserUserDeptDutyInfo;

public interface UserUserInfoDao {
	//根据用户名或者部门id或者职务id查找记录条数
	int getRowCount(@Param("username")String username,
			@Param("deptId")Integer deptId);
	
	
	//根据用户名或者部门id查找页面信息
	List<UserUserDeptDutyInfo> findPageObjects(
			@Param("username")String username,
			@Param("deptId")Integer deptId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	

}

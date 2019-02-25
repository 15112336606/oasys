package com.oa.user.dao;

import java.util.List;

import com.oa.common.vo.DeptNode;

public interface UserDeptDao {
	//通过部门找部门id
	Integer findDeptIdByDept(String dept);
	
	//查找dept的ztree节点
		List<DeptNode> findDeptZtreeNode();
}

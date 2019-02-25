package com.oa.user.service;

import java.util.List;

import com.oa.common.vo.DeptNode;

public interface UserDeptService {
	List<DeptNode> findDeptZtreeNode();
}

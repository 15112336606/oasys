package com.oa.user.dao;

import java.util.List;

import com.oa.common.vo.DutyNode;

public interface UserDutyDao {
	//查找duty的ztree节点
	List<DutyNode> findDutyZtreeNode();
}

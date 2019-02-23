package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.vo.DeptNode;
import com.oa.user.dao.UserDeptDao;
import com.oa.user.service.UserDeptService;
@Service
public class UserDeptServiceImpl implements UserDeptService{
	@Autowired
	UserDeptDao userDeptDao;
	@Override
	public List<DeptNode> findDeptZtreeNode() {
		List<DeptNode> list = userDeptDao.findDeptZtreeNode();
		for(DeptNode l:list){
			l.setName(l.getDepartment());
		}
		return list;
	}

}

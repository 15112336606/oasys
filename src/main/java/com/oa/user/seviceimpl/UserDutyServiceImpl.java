package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.vo.DutyNode;
import com.oa.user.dao.UserDutyDao;
import com.oa.user.service.UserDutyService;
@Service
public class UserDutyServiceImpl implements UserDutyService{
	@Autowired
	UserDutyDao userDutyDao;
	@Override
	public List<DutyNode> findDutyZtreeNode() {
		List<DutyNode> list = userDutyDao.findDutyZtreeNode();
		for(DutyNode l:list){
			l.setName(l.getDutyname());
		}
		return list;
	}

}

package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.vo.CheckBox;
import com.oa.user.dao.UserPurviewDao;
import com.oa.user.service.UserPurviewService;
@Service
public class UserPurviewServiceImpl implements UserPurviewService{
	@Autowired
	UserPurviewDao userPurviewDao;
	@Override
	public List<CheckBox> findPurviews() {
		return userPurviewDao.findPurviews();
	}

}

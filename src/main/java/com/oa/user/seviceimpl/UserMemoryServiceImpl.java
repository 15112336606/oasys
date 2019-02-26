package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.user.dao.UserMemoryDao;
import com.oa.user.entity.UserMemory;
import com.oa.user.exception.ServiceException;
import com.oa.user.service.UserMemoryService;
import com.oa.user.vo.Memory;

@Service
public class UserMemoryServiceImpl implements UserMemoryService{
	@Autowired
	UserMemoryDao userMemoryDao;
	@Override
	public int insertObject(UserMemory memory) {
		if(memory.getUsername()==null)throw new ServiceException("请先登录用户");
		if(memory.getStart()==null)throw new ServiceException("请设置备忘时间");
		if(memory.getTitle()==null)throw new ServiceException("请设置备忘事件");
		int rows = userMemoryDao.insertObject(memory);
		return rows;
	}
	@Override
	public List<Memory> findObjects(String username) {
		if(username==null)throw new ServiceException("请先登录");
		List<Memory> list = userMemoryDao.findObjects(username);
		for(Memory l:list)System.out.println(l);
		return list;
	}

}

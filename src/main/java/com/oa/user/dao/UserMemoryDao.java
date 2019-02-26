package com.oa.user.dao;

import java.util.List;

import com.oa.user.entity.UserMemory;
import com.oa.user.vo.Memory;

public interface UserMemoryDao {
//将备忘录数据存到库中
	int insertObject(UserMemory memory);
	List<Memory> findObjects(String username); 
}

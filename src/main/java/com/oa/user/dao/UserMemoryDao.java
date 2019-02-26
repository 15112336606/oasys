package com.oa.user.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oa.user.entity.UserMemory;
import com.oa.user.vo.Memory;

public interface UserMemoryDao {
//将备忘录数据存到库中
	int insertObject(UserMemory memory);
	List<Memory> findObjects(String username); 
	int deleteObjects(@Param("username")String username,@Param("time_start")Date time_start,@Param("time_end")Date time_end);
}

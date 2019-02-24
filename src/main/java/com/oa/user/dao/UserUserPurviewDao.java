package com.oa.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserUserPurviewDao {
	int insertObject(@Param("userId")Integer userId,@Param("purview")Integer[] purview);
	List<Integer> findPurviewsById(Integer id);
}

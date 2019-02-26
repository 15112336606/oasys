package com.oa.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.oa.user.entity.LogComment;
import com.oa.user.entity.LogInfo;
public interface UserLogDao {
	
	List<LogInfo> findPageObjects(@Param("username")String username,
								@Param("startIndex")Integer startIndex,
								@Param("pageSize")Integer pageSize);
	
	int getRowCount(@Param("username")String username);
	
	LogInfo findObjectById(@Param("id")Integer id);
	
	int insertObject(LogInfo userLog);
	
	int updateObject(LogInfo userLog);
	
	int deleteObjectsByIds(@Param("ids")Integer... ids);
	
	LogComment findCommentByLogId(@Param("id")Integer id);
	
	int insertComment(LogComment lc);
	
	int deleteComment(@Param("logId")Integer... logId);
}

package com.oa.user.service;


import com.oa.common.vo.PageObject;
import com.oa.common.vo.QueryObject;
import com.oa.user.entity.LogComment;
import com.oa.user.entity.LogInfo;

public interface UserLogService {
	PageObject<LogInfo> findPageObject(String username,Integer pageCurrent);
	
	LogInfo findObjectById(Integer id);
	
	int insertObject(LogInfo userLog);
	
	int updateObject(LogInfo userLog);
	
	int deleteObjectsByIds(Integer... ids);
	
	QueryObject doFindQureyObjectById(Integer id);
	
	int saveComment(LogComment lc);
}

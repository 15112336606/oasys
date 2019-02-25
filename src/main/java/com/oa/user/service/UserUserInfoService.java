package com.oa.user.service;

import java.util.Map;

import com.oa.common.vo.PageObject;
import com.oa.user.entity.UserUserInfo;
import com.oa.user.vo.UserUserDeptDutyInfo;

public interface UserUserInfoService {
	/**基于用户名或者岗位查找页面信息*/
PageObject<UserUserDeptDutyInfo> findPageObjects(
		String username,
		String dept,
		Integer pageCurrent);
int doSaveObject(UserUserInfo user,Integer[] purview,String cfgpassword);
Map<String,Object> doFindObjectById(Integer id);
}

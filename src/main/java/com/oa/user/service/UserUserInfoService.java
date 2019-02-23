package com.oa.user.service;

import com.oa.common.vo.PageObject;
import com.oa.user.vo.UserUserDeptDutyInfo;

public interface UserUserInfoService {
	/**基于用户名或者岗位查找页面信息*/
PageObject<UserUserDeptDutyInfo> findPageObjects(
		String username,
		String dept,
		Integer pageCurrent);
}

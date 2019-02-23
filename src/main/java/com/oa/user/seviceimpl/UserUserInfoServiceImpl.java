package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.vo.PageObject;
import com.oa.user.dao.UserDeptDao;
import com.oa.user.dao.UserUserInfoDao;
import com.oa.user.exception.ServiceException;
import com.oa.user.service.UserUserInfoService;
import com.oa.user.vo.UserUserDeptDutyInfo;
@Service
public class UserUserInfoServiceImpl implements UserUserInfoService{
	@Autowired
	UserUserInfoDao userUserInfoDao;
	@Autowired
	UserDeptDao userDeptDao;
	@Override
	public PageObject<UserUserDeptDutyInfo> findPageObjects(String username, String dept, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)throw new ServiceException("参数不合法");
		Integer deptId=null;
		if(dept!=null&&dept.equals(username)){
			deptId=userDeptDao.findDeptIdByDept(dept);
		}
		if(deptId!=null&&deptId!=0)username=null;
		int rowCount = userUserInfoDao.getRowCount(username, deptId);
		if(rowCount==0)throw new ServiceException("您搜索的部门不存在");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<UserUserDeptDutyInfo> records = userUserInfoDao.findPageObjects(username, deptId, startIndex, pageSize);
		PageObject<UserUserDeptDutyInfo> po = new PageObject<>();
		po.setPageCount((rowCount-1)/pageSize+1);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		po.setRecords(records);
		po.setRowCount(rowCount);
		return po;
	}
}

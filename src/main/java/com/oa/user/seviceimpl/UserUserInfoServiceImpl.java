package com.oa.user.seviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.oa.common.vo.PageObject;
import com.oa.user.dao.UserDeptDao;
import com.oa.user.dao.UserUserInfoDao;
import com.oa.user.dao.UserUserPurviewDao;
import com.oa.user.entity.UserUserInfo;
import com.oa.user.exception.ServiceException;
import com.oa.user.service.UserUserInfoService;
import com.oa.user.vo.UserUserDeptDutyInfo;
@Service
public class UserUserInfoServiceImpl implements UserUserInfoService{
	@Autowired
	UserUserInfoDao userUserInfoDao;
	@Autowired
	UserDeptDao userDeptDao;
	@Autowired
	UserUserPurviewDao userUserPurviewDao;
	@Override
	public PageObject<UserUserDeptDutyInfo> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)throw new ServiceException("参数不合法");
		int rowCount = userUserInfoDao.getRowCount(username);
		if(rowCount==0)throw new ServiceException("您搜索的部门不存在");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<UserUserDeptDutyInfo> records = userUserInfoDao.findPageObjects(username, startIndex, pageSize);
		PageObject<UserUserDeptDutyInfo> po = new PageObject<>();
		po.setPageCount((rowCount-1)/pageSize+1);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		po.setRecords(records);
		po.setRowCount(rowCount);
		return po;
	}
	@Override
	public int doSaveObject(UserUserInfo user, Integer[] purview,String cfgpassword) {
		if(user==null)throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(user.getUsername()))throw new ServiceException("用户名不能为空");
		int exist = userUserInfoDao.findExistObject(user.getUsername());
		if(exist!=0) throw new ServiceException("用户名已存在");
		if(StringUtils.isEmpty(user.getPassword()))throw new ServiceException("输入的密码不能为空");
		if(!user.getPassword().equals(cfgpassword))throw new ServiceException("两次输入的密码不一致");
		if(user.getDeptId()==null)throw new ServiceException("请选择对应的部门");
		if(user.getDutyId()==null)throw new ServiceException("请选择对应的职务");
		if(purview==null||purview.length==0)throw new ServiceException("请为用户分配角色");
		String salt=UUID.randomUUID().toString();
		user.setSalt(salt);
		SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword(), salt);
		user.setPassword(simpleHash.toHex());
		int rows = userUserInfoDao.doSaveObject(user);
		userUserPurviewDao.insertObject(user.getId(), purview);
		return rows;
	}
	@Override
	public Map<String, Object> doFindObjectById(Integer id) {
		if(id==null||id<1)throw new ServiceException("参数不合法");
		UserUserDeptDutyInfo result = userUserInfoDao.findObject(id);
		if(result==null)throw new ServiceException("找不到指定用户");
		List<Integer> purview = userUserPurviewDao.findPurviewsById(id);
		HashMap<String, Object> map = new HashMap<>();
		map.put("user",result);
		map.put("purview", purview);
		return map;
	}
	@Override
	public int doUpdateObject(UserUserInfo user, Integer[] purview) {
		if(user==null)throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(user.getUsername()))throw new ServiceException("用户名不能为空");
		if(user.getDeptId()==null)throw new ServiceException("请选择对应的部门");
		if(user.getDutyId()==null)throw new ServiceException("请选择对应的职务");
		if(purview==null||purview.length==0)throw new ServiceException("请为用户分配角色");
		userUserPurviewDao.deleteObjectById(user.getId());
		int rows = userUserInfoDao.updateObject(user);
		userUserPurviewDao.insertObject(user.getId(), purview);
		return rows;
	}
	@Override
	public int doUpdateValidById(Integer id, Integer valid, String modifiedUser) {
		if(id==null||id<1)throw new ServiceException("参数不合法");
		if(valid!=1&&valid!=0)
			throw new ServiceException("参数不合法,valie="+valid);
		if(StringUtils.isEmpty(modifiedUser))
			throw new ServiceException("修改用户不能为空");
		int rows = userUserInfoDao.updateValidById(id, valid, modifiedUser);
		if(rows==0)throw new ServiceException("用户不存在");
		return rows;
	}
	@Override
	public int doUpdatePassword(String password, String newPassword, String cfgPassword) {
		//...
		UserUserInfo user=(UserUserInfo)SecurityUtils.getSubject().getPrincipal();
		String username =user.getUsername();
		String salt=user.getSalt();
		String userpassword=user.getPassword();
		if(StringUtils.isEmpty(password))throw new ServiceException("请输入原密码");
		if(StringUtils.isEmpty(newPassword))throw new ServiceException("请输入新密码");
		if(StringUtils.isEmpty(cfgPassword))throw new ServiceException("请重复输入密码");
		if(!newPassword.equals(cfgPassword))throw new ServiceException("两次输入的密码不一致");
		if(newPassword.equals(password))throw new ServiceException("新密码与原密码一致");
		//请将salt改为原来的salt值
		SimpleHash sh = new SimpleHash("MD5",password,salt,1);
		if(!((sh.toHex()).equals(userpassword)))throw new ServiceException("输入原密码不正确");
		salt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",newPassword,salt,1);
		int rows = userUserInfoDao.updatePassword(username, salt,sh.toString());
		return rows;
	}
}

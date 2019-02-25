package com.oa.connection;
import java.util.List;

import org.junit.Test;
import com.oa.BaseTest;
import com.oa.user.dao.UserBasicinfoDao;
import com.oa.user.dao.UserUserInfoDao;
import com.oa.user.vo.UserUserDeptDutyInfo;
public class databaseconnectiontest extends BaseTest{
	@Test
	public void databasetest(){
		UserBasicinfoDao sbd=ctx.getBean("userBasicinfoDao",UserBasicinfoDao.class);
		int a=sbd.rowCount();
		System.out.println(a);
		System.out.println("test");
	}
	@Test
	public void userinfotest(){
		UserUserInfoDao uui = ctx.getBean("userUserInfoDao",UserUserInfoDao.class);
		int rowCount = uui.getRowCount(null, null);
		List<UserUserDeptDutyInfo> find = uui.findPageObjects(null, null, 1, 3);
		System.out.println(rowCount);
		for(UserUserDeptDutyInfo uu:find){
			System.out.println(uu);
		}
	}
}

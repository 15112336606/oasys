package com.oa.connection;
import org.junit.Test;
import com.oa.BaseTest;
import com.oa.sys.dao.SysBasicinfoDao;
public class databaseconnectiontest extends BaseTest{
	@Test
	public void databasetest(){
		SysBasicinfoDao sbd=ctx.getBean("sysBasicinfoDao",SysBasicinfoDao.class);
		int a=sbd.rowCount();
		System.out.println(a);
		System.out.println("test");
	}
}

package com.oa.common.utils;

import java.util.List;

import com.oa.common.vo.PageObject;


public class PageUtils {
	
	
	public static <T>PageObject<T> newPageObject(
					int pageCount,
					int pageCurrent,
					int pageSize,
					int rowCount,
					List<T> records){
		PageObject<T> po = new PageObject<>();
		po.setPageCount(pageCount);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		po.setRecords(records);
		po.setRowCount(rowCount);
		return po;
	}
}

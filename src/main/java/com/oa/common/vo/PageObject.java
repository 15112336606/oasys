package com.oa.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 此vo用于封装页面信息
 * @author UID
 *
 */
public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = 2650656606867990907L;
private Integer pageCurrent=1;
private Integer pageSize=3;
private Integer rowCount=0;
private Integer pageCount=0;
private List<T> records;
public Integer getPageCurrent() {
	return pageCurrent;
}
public void setPageCurrent(Integer pageCurrent) {
	this.pageCurrent = pageCurrent;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getRowCount() {
	return rowCount;
}
public void setRowCount(Integer rowCount) {
	this.rowCount = rowCount;
}
public Integer getPageCount() {
	return pageCount;
}
public void setPageCount(Integer pageCount) {
	this.pageCount = pageCount;
}
public List<T> getRecords() {
	return records;
}
public void setRecords(List<T> records) {
	this.records = records;
}
@Override
public String toString() {
	return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
			+ ", pageCount=" + pageCount + ", records=" + records + "]";
}

}

package com.oa.common.vo;

import java.io.Serializable;

import com.oa.user.entity.LogComment;
import com.oa.user.entity.LogInfo;

public class QueryObject implements Serializable{

	private static final long serialVersionUID = -4874104159709690808L;
	private LogComment logComment;
	private LogInfo logInfo;
	public QueryObject() {
		super();
	}
	public QueryObject(LogComment logComment, LogInfo logInfo) {
		super();
		this.logComment = logComment;
		this.logInfo = logInfo;
	}
	
	public LogComment getLogComment() {
		return logComment;
	}
	public void setLogComment(LogComment logComment) {
		this.logComment = logComment;
	}
	public LogInfo getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(LogInfo logInfo) {
		this.logInfo = logInfo;
	}
	
}

package com.oa.user.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.utils.PageUtils;
import com.oa.common.vo.PageObject;
import com.oa.common.vo.QueryObject;
import com.oa.user.dao.UserLogDao;
import com.oa.user.entity.LogComment;
import com.oa.user.entity.LogInfo;
import com.oa.user.exception.ServiceException;
import com.oa.user.service.UserLogService;
@Service
public class UserLogServiceImpl implements UserLogService{
	@Autowired
	private UserLogDao userLogDao;
	
	@Override
	public PageObject<LogInfo> findPageObject(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码值不正确");
		int rowCount = userLogDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有找到对应记录");
		int pageSize = 5;
		int pageCount = (rowCount-1)/pageSize+1;
		int startIndex = (pageCurrent-1)*pageSize;
		List<LogInfo> records = userLogDao.findPageObjects(username, startIndex, pageSize);
		PageObject<LogInfo> po = PageUtils.newPageObject(pageCount, pageCurrent,
													pageSize, rowCount, records);
		return po;
	}

	@Override
	public LogInfo findObjectById(Integer id) {
		if(id==null||id<1)
			throw new ServiceException("id不正确");
		LogInfo li = userLogDao.findObjectById(id);
		if(li==null)
			throw new ServiceException("找不到指定记录");
		return li;
	}

	@Override
	public int insertObject(LogInfo userLog) {
		if(userLog.getUserid()==null){
			throw new ServiceException("用户ID不能为空");
		}else if(userLog.getTitle()==null||userLog.getTitle()==""){
			throw new ServiceException("请输入日志主题");
		}else if(userLog.getContent()==null||userLog.getContent()==""){
			throw new ServiceException("请输入日志内容");
		}
		int row = userLogDao.insertObject(userLog);
		if(row==0)
			throw new ServiceException("添加失败");
		return row;
	}

	@Override
	public int updateObject(LogInfo userLog) {
		if(userLog.getId()==null||userLog.getId()<0){
			throw new ServiceException("id值不能为空或不正确");
		}else if(userLog.getCreatedUser()==null||userLog.getCreatedUser()==""){
			throw new ServiceException("用户名不能为空");
		}else if(userLog.getTitle()==null||userLog.getTitle()==""){
			throw new ServiceException("日志主题不能为空");
		}else if(userLog.getContent()==null||userLog.getContent()=="")
			throw new ServiceException("日志内容不能为空");
		int row = userLogDao.updateObject(userLog);
		if(row==0)
			throw new ServiceException("修改日志失败");
		return row;
	}

	@Override
	public int deleteObjectsByIds(Integer... ids) {
		if(ids==null||ids.length==0)
			throw new ServiceException("请勾选要删除的选项");
		int rows = userLogDao.deleteObjectsByIds(ids);
		if(rows==0)
			throw new ServiceException("删除失败");
			userLogDao.deleteComment(ids);
		return rows;
	}

	@Override
	public QueryObject doFindQureyObjectById(Integer id) {
		if(id==null||id<1)
			throw new ServiceException("id不正确");
		LogInfo li = userLogDao.findObjectById(id);
		if(li==null)
			throw new ServiceException("找不到指定记录");
		LogComment lc= userLogDao.findCommentByLogId(id);
		QueryObject QO = new QueryObject(lc,li);
		return QO;
	}

	@Override
	public int saveComment(LogComment lc) {
		if(lc.getCommentcontent()==null||lc.getCommentcontent()=="")
			throw new ServiceException("评论内容不能为空");
		int row = userLogDao.insertComment(lc);
		if(row==0)
			throw new ServiceException("评论提交失败");
		return row;
	}

	
}

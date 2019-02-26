package com.oa.user.entity;
/**这个entity用来封装Log字段信息*/
public class LogInfo extends BaseEntity{

	private static final long serialVersionUID = 1510620408345559338L;
	
	private Integer id;
	
	private String title;
	
	private String content;
	
	private Integer userid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserLog [id=" + id + ", title=" + title + ", content=" + content + ", userid=" + userid + ",createdTime="+super.getCreatedTime()+",credtedUser="+super.getCreatedUser()+"]";
	}
}

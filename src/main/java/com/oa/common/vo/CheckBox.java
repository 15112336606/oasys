package com.oa.common.vo;

import java.io.Serializable;

public class CheckBox implements Serializable{
	private static final long serialVersionUID = -4917022286442205204L;
	private int ID;
	private String purviewname;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPurviewname() {
		return purviewname;
	}
	public void setPurviewname(String purviewname) {
		this.purviewname = purviewname;
	}
	@Override
	public String toString() {
		return "CheckBox [ID=" + ID + ", purviewname=" + purviewname + "]";
	}
	
}

package com.kidder.springBootStarter.Model;

import java.io.Serializable;

public class UserGrpReqstStatusInfoModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -880553665913009659L;
	private String user_username;
	private int grp_reqst_status;
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public int getGrp_reqst_status() {
		return grp_reqst_status;
	}
	public void setGrp_reqst_status(int grp_reqst_status) {
		this.grp_reqst_status = grp_reqst_status;
	}
}

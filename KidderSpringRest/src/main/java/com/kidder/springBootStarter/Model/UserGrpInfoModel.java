package com.kidder.springBootStarter.Model;

import java.io.Serializable;
import java.util.List;

public class UserGrpInfoModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5567382070641787207L;
	private String user_username;
	private long grp_reqst_id;
	private String grp_name;
	private String grp_admin;
	private int grp_reqst_status;
	private boolean isReqstFrmUser;
	private boolean isReqstFrmGrpAdmin;
	public boolean isReqstFrmUser() {
		return isReqstFrmUser;
	}
	public void setReqstFrmUser(boolean isReqstFrmUser) {
		this.isReqstFrmUser = isReqstFrmUser;
	}
	public boolean isReqstFrmGrpAdmin() {
		return isReqstFrmGrpAdmin;
	}
	public void setReqstFrmGrpAdmin(boolean isReqstFrmGrpAdmin) {
		this.isReqstFrmGrpAdmin = isReqstFrmGrpAdmin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private List<UserGrpReqstStatusInfoModel> user_list;
	public int getGrp_reqst_status() {
		return grp_reqst_status;
	}
	public void setGrp_reqst_status(int grp_reqst_status) {
		this.grp_reqst_status = grp_reqst_status;
	}
	public long getGrp_reqst_id() {
		return grp_reqst_id;
	}
	public void setGrp_reqst_id(long grp_reqst_id) {
		this.grp_reqst_id = grp_reqst_id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getGrp_name() {
		return grp_name;
	}
	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}
	public String getGrp_admin() {
		return grp_admin;
	}
	public void setGrp_admin(String grp_admin) {
		this.grp_admin = grp_admin;
	}
	public List<UserGrpReqstStatusInfoModel> getUser_list() {
		return user_list;
	}
	public void setUser_list(List<UserGrpReqstStatusInfoModel> user_list) {
		this.user_list = user_list;
	}

}

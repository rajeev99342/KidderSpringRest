package com.kidder.springBootStarter.Model;

import java.io.Serializable;

import com.kidder.springBootStarter.Pojo.UserInfoTbl;

public class GroupModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long grp_id;
	private String grp_name;
	private String grp_desc;
	private String grp_unique_code;
	
	private String grp_admin;
	
	

	private String status;
	private String error;
	
	public long getGrp_id() {
		return grp_id;
	}
	public void setGrp_id(long grp_id) {
		this.grp_id = grp_id;
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
	public String getGrp_desc() {
		return grp_desc;
	}
	public void setGrp_desc(String grp_desc) {
		this.grp_desc = grp_desc;
	}
	public String getGrp_unique_code() {
		return grp_unique_code;
	}
	public void setGrp_unique_code(String grp_unique_code) {
		this.grp_unique_code = grp_unique_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	
	

}

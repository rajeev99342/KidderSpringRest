package com.kidder.springBootStarter.Model;

import java.io.Serializable;

public class KiUserModel extends CommonColumnModel {
	   private Long user_id;
	   private String  user_name;
	   private String  user_username;
	   private String  user_password;
	   private String  user_email ;
	   private long user_phone_number;
	   private String error;
	   private String status;
	   
	   public long getUser_phone_number() {
		return user_phone_number;
	}
	public void setUser_phone_number(long user_phone_number) {
		this.user_phone_number = user_phone_number;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

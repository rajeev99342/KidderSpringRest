package com.kidder.springBootStarter.Model;

import java.io.Serializable;

public class KiUserModel extends CommonColumnModel {
	private Long user_id;
	private String user_name;
	private String user_username;
	private String user_password;
	private String user_email;
	private String user_token;
	private String user_fb_id;
	private String user_fb_pic;
	private int user_type;
	
	
	public String getUser_fb_id() {
		return user_fb_id;
	}

	public void setUser_fb_id(String user_fb_id) {
		this.user_fb_id = user_fb_id;
	}

	public String getUser_fb_pic() {
		return user_fb_pic;
	}

	public void setUser_fb_pic(String user_fb_pic) {
		this.user_fb_pic = user_fb_pic;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	private boolean admin;
	


	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

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

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
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

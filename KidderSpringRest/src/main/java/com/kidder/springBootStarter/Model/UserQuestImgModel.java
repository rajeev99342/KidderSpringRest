package com.kidder.springBootStarter.Model;

import java.io.Serializable;

public class UserQuestImgModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5354598947424245650L;
	
	private long user_quest_img_id;
	private boolean isDelete;
	private String user_quest_img_base64_url;
	private String user_quest_img_desc;
	
	private String user_quest_img_path;
	private boolean isEdit;
	private String user_quest_img_name;
	public String getUser_quest_img_name() {
		return user_quest_img_name;
	}
	public void setUser_quest_img_name(String user_quest_img_name) {
		this.user_quest_img_name = user_quest_img_name;
	}
	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getUser_quest_img_base64_url() {
		return user_quest_img_base64_url;
	}
	public void setUser_quest_img_base64_url(String user_quest_img_base64_url) {
		this.user_quest_img_base64_url = user_quest_img_base64_url;
	}
	public String getUser_quest_img_desc() {
		return user_quest_img_desc;
	}
	public void setUser_quest_img_desc(String user_quest_img_desc) {
		this.user_quest_img_desc = user_quest_img_desc;
	}
	public long getUser_quest_img_id() {
		return user_quest_img_id;
	}
	public void setUser_quest_img_id(long user_quest_img_id) {
		this.user_quest_img_id = user_quest_img_id;
	}
	public String getUser_quest_img_path() {
		return user_quest_img_path;
	}
	public void setUser_quest_img_path(String user_quest_img_path) {
		this.user_quest_img_path = user_quest_img_path;
	}

	
}

package com.kidder.springBootStarter.Model;

public class ImageInfoModel  extends CommonColumnModel{
    private Long img_id;
	
	private String img_name;
	

	private String img_path;
	private String img_base64;

	
	private Boolean toBeDeleted; 

	private String img_desc;
	
	public Boolean getToBeDeleted() {
		return toBeDeleted;
	}


	public void setToBeDeleted(Boolean toBeDeleted) {
		this.toBeDeleted = toBeDeleted;
	}


	public String getImg_base64() {
		return img_base64;
	}


	public void setImg_base64(String img_base64) {
		this.img_base64 = img_base64;
	}




	public Long getImg_id() {
		return img_id;
	}


	public void setImg_id(Long img_id) {
		this.img_id = img_id;
	}


	public String getImg_name() {
		return img_name;
	}


	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	public String getImg_desc() {
		return img_desc;
	}


	public void setImg_desc(String img_desc) {
		this.img_desc = img_desc;
	}
	
	
	
}

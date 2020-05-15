package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "image_info_tbl")
@Component
public class ImageInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long img_id;
	
	private String img_name;
	

	private String img_path;
	

	private String img_desc;
	
	
	private String img_base64;
	
	private String unique_code;
	

	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_unique_code" )
	public String getUnique_code() {
		return unique_code;
	}

	public void setUnique_code(String unique_code) {
		this.unique_code = unique_code;
	}

	public Long getImg_id() {
		return img_id;
	}

	public void setImg_id(Long img_id) {
		this.img_id = img_id;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_base64" )
	public String getImg_base64() {
		return img_base64;
	}

	public void setImg_base64(String img_base64) {
		this.img_base64 = img_base64;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_name" )
	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_path" )
	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_desc" )
	public String getImg_desc() {
		return img_desc;
	}

	public void setImg_desc(String img_desc) {
		this.img_desc = img_desc;
	}



	
}

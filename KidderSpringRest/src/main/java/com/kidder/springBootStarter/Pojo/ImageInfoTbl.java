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
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_name" )
	private String img_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_path" )
	private String img_path;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "img_desc" )
	private String img_desc;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "is_dgrm_img" )
	private boolean is_dgrm_img;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "is_quest_img" )
	private boolean is_quest_img;

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

	public boolean isIs_dgrm_img() {
		return is_dgrm_img;
	}

	public void setIs_dgrm_img(boolean is_dgrm_img) {
		this.is_dgrm_img = is_dgrm_img;
	}

	public boolean isIs_quest_img() {
		return is_quest_img;
	}

	public void setIs_quest_img(boolean is_quest_img) {
		this.is_quest_img = is_quest_img;
	}
}

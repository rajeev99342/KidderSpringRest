package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@javax.persistence.Table(name="ki_img_tbl",indexes = 
{@javax.persistence.Index(name="ki_img_tbl_pk",columnList = "img_id",unique = true)})
public class KiImgTbl extends AbstractHibernateObject{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@javax.persistence.Basic
	@javax.persistence.Column(name = "img_id")
	public Long getImg_id() {
		return super.getId();
	}

	public void setImg_id(Long img_id) {
		super.setId(img_id);
	}

	
	private String img_name;
	

	private String img_path;
	

	private String img_desc;
	
	
	private String img_base64;	

	private long user_quest_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "unique_code" )
	public String getUnique_code() {
		return super.getUniqueCode();
	}

	public void setUnique_code(String unique_code) {
		super.setUniqueCode(unique_code);
	}

	@javax.persistence.Basic
	@javax.persistence.Column(name = "deleteFl")

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}


	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
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


	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_id" )
	
	public long getUser_quest_id() {
		return user_quest_id;
	}

	public void setUser_quest_id(long user_quest_id) {
		this.user_quest_id = user_quest_id;
	}
	
}

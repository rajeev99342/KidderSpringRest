
package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "dgrm_image_info_tbl")
@Component
public class DgrmImageInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dgrm_img_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_name" )
	private String dgrm_img_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_path" )
	private String dgrm_img_path;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_desc" )
	private String dgrm_img_desc;

	public Long getDgrm_img_id() {
		return dgrm_img_id;
	}

	public void setDgrm_img_id(Long dgrm_img_id) {
		this.dgrm_img_id = dgrm_img_id;
	}

	public String getDgrm_img_name() {
		return dgrm_img_name;
	}

	public void setDgrm_img_name(String dgrm_img_name) {
		this.dgrm_img_name = dgrm_img_name;
	}

	public String getDgrm_img_path() {
		return dgrm_img_path;
	}

	public void setDgrm_img_path(String dgrm_img_path) {
		this.dgrm_img_path = dgrm_img_path;
	}

	public String getDgrm_img_desc() {
		return dgrm_img_desc;
	}

	public void setDgrm_img_desc(String dgrm_img_desc) {
		this.dgrm_img_desc = dgrm_img_desc;
	}
	


}


package com.kidder.springBootStarter.Pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@javax.persistence.Table(name="ki_dgrm_img_tbl",indexes = 
{@javax.persistence.Index(name="ki_dgrm_img_tbl_pk",columnList = "dgrm_img_id",unique = true)})
public class KiDgrmImgTbl extends AbstractHibernateObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_id")
	public Long getDgrm_img_id() {
		return super.getId();
	}

	public void setDgrm_img_id(Long dgrm_img_id) {
		super.setId(dgrm_img_id);
	}

	public String getDgrm_img_name() {
		return dgrm_img_name;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_name" )
	private String dgrm_img_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_path" )
	private String dgrm_img_path;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_desc" )
	private String dgrm_img_desc;
	
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_base64" )
	private String dgrm_img_base64;
	
	public String getDgrm_img_base64() {
		return dgrm_img_base64;
	}

	public void setDgrm_img_base64(String dgrm_img_base64) {
		this.dgrm_img_base64 = dgrm_img_base64;
	}



	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_id" , nullable = false)
	@org.hibernate.annotations.Type(type = "long")
	private long  ki_kidder_quest_id;
	public long getKi_kidder_quest_id() {
		return ki_kidder_quest_id;
	}

	public void setKi_kidder_quest_id(long ki_kidder_quest_id) {
		this.ki_kidder_quest_id = ki_kidder_quest_id;
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
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "delete_fl" )

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}

	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}
	@javax.persistence.Basic
	@javax.persistence.Column(name = "unique_code")
	public String getUniqueCode() {
		return super.getUniqueCode();
	}


	public void setUniqueCode(String uniqueCode) {
		super.setUniqueCode(uniqueCode);
	}

	

}

package com.kidder.springBootStarter.Pojo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;


@Entity
@javax.persistence.Table(name="ki_group_tbl",indexes = 
{@javax.persistence.Index(name="ki_group_tbl_pk",columnList = "grp_id",unique = true)})
public class KiGroupTbl extends AbstractHibernateObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_id" )
	public Long getGrp_id() {
		return super.getId();
	}

	public void setGrp_id(Long grp_id) {
		super.setId(grp_id);
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_name" )
	private String grp_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_admin" )
	private String grp_admin;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_desc" )
	private String grp_desc;



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

	@javax.persistence.Basic
	@javax.persistence.Column(name = "unique_code")
	public String getUniqueCode() {
		return super.getUniqueCode();
	}


	public void setUniqueCode(String uniqueCode) {
		super.setUniqueCode(uniqueCode);
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "delete_fl" )

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}

	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}

}

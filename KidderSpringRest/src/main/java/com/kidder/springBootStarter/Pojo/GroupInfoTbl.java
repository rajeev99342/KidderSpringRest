package com.kidder.springBootStarter.Pojo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "group_info_tbl")
@Component
public class GroupInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grp_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_name" )
	private String grp_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_admin" )
	private String grp_admin;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_desc" )
	private String grp_desc;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_unique_code" )
	private String grp_unique_code;

	public Long getGrp_id() {
		return grp_id;
	}

	public void setGrp_id(Long grp_id) {
		this.grp_id = grp_id;
	}

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

	public String getGrp_unique_code() {
		return grp_unique_code;
	}

	public void setGrp_unique_code(String grp_unique_code) {
		this.grp_unique_code = grp_unique_code;
	}
	
	
}

package com.kidder.springBootStarter.Pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "grp_reqst_tbl")
@Component
public class GrpReqstTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grp_reqst_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_name" )
	private String grp_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_username" )
	private String user_username;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_reqst_status" )
	private int grp_reqst_status;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_reqst_date" )
	private Timestamp grp_reqst_date;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_reqst_lst_modified" )
	private Timestamp grp_reqst_lst_modified;

	public Long getGrp_reqst_id() {
		return grp_reqst_id;
	}

	public void setGrp_reqst_id(Long grp_reqst_id) {
		this.grp_reqst_id = grp_reqst_id;
	}

	public String getGrp_name() {
		return grp_name;
	}

	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public int getGrp_reqst_status() {
		return grp_reqst_status;
	}

	public void setGrp_reqst_status(int grp_reqst_status) {
		this.grp_reqst_status = grp_reqst_status;
	}

	public Timestamp getGrp_reqst_date() {
		return grp_reqst_date;
	}

	public void setGrp_reqst_date(Timestamp grp_reqst_date) {
		this.grp_reqst_date = grp_reqst_date;
	}

	public Timestamp getGrp_reqst_lst_modified() {
		return grp_reqst_lst_modified;
	}

	public void setGrp_reqst_lst_modified(Timestamp grp_reqst_lst_modified) {
		this.grp_reqst_lst_modified = grp_reqst_lst_modified;
	}
	
}

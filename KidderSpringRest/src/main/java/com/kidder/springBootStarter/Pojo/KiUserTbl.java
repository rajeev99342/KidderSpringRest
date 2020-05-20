package com.kidder.springBootStarter.Pojo;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ki_user_tbl")
@Component
public class KiUserTbl extends AbstractHibernateObject{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_id" )
    private Long user_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_name" )
	private String user_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_username" )
	private String user_username;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_password" )
	private String user_password;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_email" )
	private String user_email;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_phone_number" )
	private long user_phone_number;

	 
	public Long getUser_id() {
		return super.getId();
	}

	public void setUser_id(Long user_id) {
		super.setId(user_id);
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public long getUser_phone_number() {
		return user_phone_number;
	}

	public void setUser_phone_number(long user_phone_number) {
		this.user_phone_number = user_phone_number;
	}


	
	
	
}

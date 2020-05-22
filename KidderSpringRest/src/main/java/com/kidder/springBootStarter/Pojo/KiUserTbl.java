package com.kidder.springBootStarter.Pojo;


import javax.persistence.Entity;



@Entity
@javax.persistence.Table(name="ki_user_tbl",indexes = 
{@javax.persistence.Index(name="ki_user_tbl_pk",columnList = "user_id",unique = true)})
public class KiUserTbl extends AbstractHibernateObject{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_name;
	private String user_username;
	private long user_phone_number;
	private String user_email;
	private String user_password;

	@javax.persistence.Id
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_id" ,unique = true, nullable = false)
	public Long getUser_id() {
		return super.getId();
	}

	public void setUser_id(Long user_id) {
		super.setId(user_id);
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_name" )
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_username" )
	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_password" )
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_email" )

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_phone_number" )


	public long getUser_phone_number() {
		return user_phone_number;
	}

	public void setUser_phone_number(long user_phone_number) {
		this.user_phone_number = user_phone_number;
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


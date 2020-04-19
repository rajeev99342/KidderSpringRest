package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_tbl2")
public class TestTbl {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String first_name;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "name" )
	
	
	
	private String last_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "first_name" )
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "last_name" )
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
}

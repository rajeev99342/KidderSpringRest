package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ki_topic_tbl")
@Component
public class KiTopicTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ki_topic_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_topic_name" )
	private String ki_topic_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_topic_code" )
	private String ki_topic_code;
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_sub_id" )
	@org.hibernate.annotations.Type(type = "long")

	private long ki_sub_id;


	public Long getKi_topic_id() {
		return ki_topic_id;
	}


	public void setKi_topic_id(Long ki_topic_id) {
		this.ki_topic_id = ki_topic_id;
	}


	public String getKi_topic_name() {
		return ki_topic_name;
	}


	public void setKi_topic_name(String ki_topic_name) {
		this.ki_topic_name = ki_topic_name;
	}


	public String getKi_topic_code() {
		return ki_topic_code;
	}


	public void setKi_topic_code(String ki_topic_code) {
		this.ki_topic_code = ki_topic_code;
	}


	public Long getKi_sub_id() {
		return ki_sub_id;
	}


	public void setKi_sub_id(Long ki_sub_id) {
		this.ki_sub_id = ki_sub_id;
	}



	
	
}

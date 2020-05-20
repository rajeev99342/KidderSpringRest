package com.kidder.springBootStarter.Pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ki_sub_tbl")
@Component
public class KiSubjectTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ki_sub_id;
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_sub_code" )
	private String ki_sub_code;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_sub_name" )
	private String ki_sub_name;
	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name ="ki_sub_id" ,updatable = false,insertable = false)
	private Set<KiTopicTbl> kiTopicTbl;
	

	
	public Set<KiTopicTbl> getKiTopicTbl() {
		return kiTopicTbl;
	}

	public void setKiTopicTbl(Set<KiTopicTbl> kiTopicTbl) {
		this.kiTopicTbl = kiTopicTbl;
	}

	public Long getKi_sub_id() {
		return ki_sub_id;
	}

	public void setKi_sub_id(Long ki_sub_id) {
		this.ki_sub_id = ki_sub_id;
	}

	public String getKi_sub_code() {
		return ki_sub_code;
	}

	public void setKi_sub_code(String ki_sub_code) {
		this.ki_sub_code = ki_sub_code;
	}

	public String getKi_sub_name() {
		return ki_sub_name;
	}

	public void setKi_sub_name(String ki_sub_name) {
		this.ki_sub_name = ki_sub_name;
	}

	
	
}

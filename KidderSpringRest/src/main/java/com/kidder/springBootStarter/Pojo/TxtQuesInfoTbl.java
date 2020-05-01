package com.kidder.springBootStarter.Pojo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="txt_ques_tbl")
public class TxtQuesInfoTbl {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long txt_ques_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "dgrm_img_name" )
	private String dgrm_img_name;

	public long getTxt_ques_id() {
		return txt_ques_id;
	}

	public void setTxt_ques_id(long txt_ques_id) {
		this.txt_ques_id = txt_ques_id;
	}

	public String getDgrm_img_name() {
		return dgrm_img_name;
	}

	public void setDgrm_img_name(String dgrm_img_name) {
		this.dgrm_img_name = dgrm_img_name;
	}
	
	
	
}


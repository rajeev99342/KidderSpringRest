package com.kidder.springBootStarter.Pojo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ki_txt_quest_tbl")
public class KiTxtQuestTbl extends AbstractHibernateObject{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long txt_ques_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column(length = 4000, name = "ques_txt" )
	private String quesTxt;

	@javax.persistence.Basic
	@javax.persistence.Column(name = "txt_ques_id" )
	public Long getTxt_ques_id() {
		return super.getId();
	}

	public void setTxt_ques_id(Long txt_ques_id) {
		super.setId(txt_ques_id);
	}

	public String getQuesTxt() {
		return quesTxt;
	}

	public void setQuesTxt(String quesTxt) {
		this.quesTxt = quesTxt;
	}

	
	
	
}


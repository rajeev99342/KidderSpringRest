package com.kidder.springBootStarter.Pojo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@javax.persistence.Table(name="ki_txt_quest_tbl",indexes = 
{@javax.persistence.Index(name="ki_txt_quest_tbl_pk",columnList = "txt_ques_id",unique = true)})
public class KiTxtQuestTbl extends AbstractHibernateObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String quesTxt;

	@Id
	@javax.persistence.Basic
	@javax.persistence.Column(name = "txt_ques_id")
	public Long getTxt_ques_id() {
		return super.getId();
	}

	public void setTxt_ques_id(Long txt_ques_id) {
		super.setId(txt_ques_id);
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column(length = 4000, name = "ques_txt" )



	public String getQuesTxt() {
		return quesTxt;
	}

	public void setQuesTxt(String quesTxt) {
		this.quesTxt = quesTxt;
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


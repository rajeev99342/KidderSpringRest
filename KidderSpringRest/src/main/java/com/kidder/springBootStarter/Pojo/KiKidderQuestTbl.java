package com.kidder.springBootStarter.Pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ki_kidder_quest_tbl")

public class KiKidderQuestTbl extends AbstractHibernateObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ki_kidder_quest_id;

	private String ki_kidder_quest_name;
	
	private String ki_kidder_quest_optionA;
	
	private String ki_kidder_quest_optionB;
	
	private String ki_kidder_quest_optionC;
	
	private String ki_kidder_quest_optionD;
	
	private String ki_kidder_quest_sub;
	
	private String ki_kidder_quest_topic;
	
	private Integer ki_kidder_quest_level;
	
	private String ki_kidder_quest_ans;
	
	private Double ki_kidder_quest_marks;




	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_id" )
	public void setKi_kidder_quest_id(Long ki_kidder_quest_id) {
		super.setId(ki_kidder_quest_id);
	}
	public Long getKi_kidder_quest_id() {
		return super.getId();
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_topic" )

	public String getKi_kidder_quest_topic() {
		return ki_kidder_quest_topic;
	}


	public void setKi_kidder_quest_topic(String ki_kidder_quest_topic) {
		this.ki_kidder_quest_topic = ki_kidder_quest_topic;
	}
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_sub" )
	public void setKi_kidder_quest_sub(String ki_kidder_quest_sub) {
		this.ki_kidder_quest_sub = ki_kidder_quest_sub;
	}




	public void setKi_kidder_quest_level(Integer ki_kidder_quest_level) {
		this.ki_kidder_quest_level = ki_kidder_quest_level;
	}


	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_level" )
	public Integer getKi_kidder_quest_level() {
		return ki_kidder_quest_level;
	}


	public String getKi_kidder_quest_sub() {
		return ki_kidder_quest_sub;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_name" )
	public String getKi_kidder_quest_name() {
		return ki_kidder_quest_name;
	}






	public void setKi_kidder_quest_name(String ki_kidder_quest_name) {
		this.ki_kidder_quest_name = ki_kidder_quest_name;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_optionA" )
 
	 
	public String getKi_kidder_quest_optionA() {
		return ki_kidder_quest_optionA;
	}


	public void setKi_kidder_quest_optionA(String ki_kidder_quest_optionA) {
		this.ki_kidder_quest_optionA = ki_kidder_quest_optionA;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_optionB" )
  
	public String getKi_kidder_quest_optionB() {
		return ki_kidder_quest_optionB;
	}


	public void setKi_kidder_quest_optionB(String ki_kidder_quest_optionB) {
		this.ki_kidder_quest_optionB = ki_kidder_quest_optionB;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_optionC" )
  
	public String getKi_kidder_quest_optionC() {
		return ki_kidder_quest_optionC;
	}


	public void setKi_kidder_quest_optionC(String ki_kidder_quest_optionC) {
		this.ki_kidder_quest_optionC = ki_kidder_quest_optionC;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_optionD" )
   
	
	public String getKi_kidder_quest_optionD() {
		return ki_kidder_quest_optionD;
	}


	public void setKi_kidder_quest_optionD(String ki_kidder_quest_optionD) {
		this.ki_kidder_quest_optionD = ki_kidder_quest_optionD;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "ki_kidder_quest_ans" )
	public String getKi_kidder_quest_ans() {
		return ki_kidder_quest_ans;
	}


	public void setKi_kidder_quest_ans(String ki_kidder_quest_ans) {
		this.ki_kidder_quest_ans = ki_kidder_quest_ans;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "ki_kidder_quest_marks")
  
	public Double getKi_kidder_quest_marks() {
		return ki_kidder_quest_marks;
	}


	public void setKi_kidder_quest_marks(Double ki_kidder_quest_marks) {
		this.ki_kidder_quest_marks = ki_kidder_quest_marks;
	}

	
	
	@javax.persistence.Basic
	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name="txt_ques_id")
	private KiTxtQuestTbl txtQuesInfoTbl;



	public KiTxtQuestTbl getTxtQuesInfoTbl() {
		return txtQuesInfoTbl;
	}

	public void setTxtQuesInfoTbl(KiTxtQuestTbl txtQuesInfoTbl) {
		this.txtQuesInfoTbl = txtQuesInfoTbl;
	}
	


	@javax.persistence.Basic
	@ManyToOne(cascade = {CascadeType.DETACH},fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private KiUserTbl userInfoTbl;

	public KiUserTbl getUserInfoTbl() {
		return userInfoTbl;
	}

	public void setUserInfoTbl(KiUserTbl userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}
	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ki_kidder_quest_id",updatable = false,insertable = false)
	private Set<KiDgrmImgTbl> dgrmImgInfoTbls;



	public Set<KiDgrmImgTbl> getDgrmImgInfoTbls() {
		return dgrmImgInfoTbls;
	}


	public void setDgrmImgInfoTbls(Set<KiDgrmImgTbl> dgrmImgInfoTbls) {
		this.dgrmImgInfoTbls = dgrmImgInfoTbls;
	}






	

}

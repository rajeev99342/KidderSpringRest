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
@javax.persistence.Table(name="ki_user_quest_tbl",indexes = 
{@javax.persistence.Index(name="ki_user_quest_tbl_pk",columnList = "user_quest_id",unique = true)})
public class KiUserQuestTbl extends AbstractHibernateObject {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@javax.persistence.Column(name="user_quest_id")
	@org.hibernate.annotations.Type(type="long")
	public Long getUser_quest_id() {
		return super.getId();
	}

	public void setUser_quest_id(Long user_quest_id) {
		super.setId(user_quest_id);
	}
	private Set<KiImgTbl> imgInfoTbl;

	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_quest_id",updatable = false,insertable = false)
	public Set<KiImgTbl> getImgInfoTbl() {
		return imgInfoTbl;
	}

	public void setImgInfoTbl(Set<KiImgTbl> imgInfoTbl) {
		this.imgInfoTbl = imgInfoTbl;
	}



	private long quiz_id;
	private String user_quest_name;
	

	private String user_quest_optionA;
	

	private String user_quest_optionB;
	

	private String user_quest_optionC;
	

	private String user_quest_optionD;
	

	private String user_quest_ans;
	

	private double user_quest_marks;

	private KiTxtQuestTbl txtQuesInfoTbl;
	private KiUserTbl userInfoTbl;


	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_name" )
	public String getUser_quest_name() {
		return user_quest_name;
	}

	public void setUser_quest_name(String user_quest_name) {
		this.user_quest_name = user_quest_name;
	}
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionA" )
	public String getUser_quest_optionA() {
		return user_quest_optionA;
	}

	public void setUser_quest_optionA(String user_quest_optionA) {
		this.user_quest_optionA = user_quest_optionA;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionB" )
	public String getUser_quest_optionB() {
		return user_quest_optionB;
	}

	public void setUser_quest_optionB(String user_quest_optionB) {
		this.user_quest_optionB = user_quest_optionB;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionC" )
	public String getUser_quest_optionC() {
		return user_quest_optionC;
	}

	public void setUser_quest_optionC(String user_quest_optionC) {
		this.user_quest_optionC = user_quest_optionC;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionD" )
	public String getUser_quest_optionD() {
		return user_quest_optionD;
	}

	public void setUser_quest_optionD(String user_quest_optionD) {
		this.user_quest_optionD = user_quest_optionD;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_ans" )
	public String getUser_quest_ans() {
		return user_quest_ans;
	}

	public void setUser_quest_ans(String user_quest_ans) {
		this.user_quest_ans = user_quest_ans;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "user_quest_marks")
	public double getUser_quest_marks() {
		return user_quest_marks;
	}

	public void setUser_quest_marks(double user_quest_marks) {
		this.user_quest_marks = user_quest_marks;
	} 
	
	@javax.persistence.Basic
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="txt_ques_id",nullable = true)

	public KiTxtQuestTbl getTxtQuesInfoTbl() {
		return txtQuesInfoTbl;
	}

	public void setTxtQuesInfoTbl(KiTxtQuestTbl txtQuesInfoTbl) {
		this.txtQuesInfoTbl = txtQuesInfoTbl;
	}
	


	@javax.persistence.Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")

	public KiUserTbl getUserInfoTbl() {
		return userInfoTbl;
	}

	public void setUserInfoTbl(KiUserTbl userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}


	@javax.persistence.Basic
	@JoinColumn(name = "quiz_id")

	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "unique_code" )
	public String getUnique_code() {
		return super.getUniqueCode();
	}

	public void setUnique_code(String unique_code) {
		super.setUniqueCode(unique_code);
	}

	@javax.persistence.Basic
	@javax.persistence.Column(name = "deleteFl")

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}


	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}
}

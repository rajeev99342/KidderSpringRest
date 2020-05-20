package com.kidder.springBootStarter.Pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_quest_info_tbl")

public class UserQuestInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_quest_id;

	
//
	
	@javax.persistence.Basic
	@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name = "img_id")
	private KiImgTbl imgInfoTbl;

	public KiImgTbl getImgInfoTbl() {
		return imgInfoTbl;
	}

	public void setImgInfoTbl(KiImgTbl imgInfoTbl) {
		this.imgInfoTbl = imgInfoTbl;
	}

//	@javax.persistence.Basic
//	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
//	@JoinColumn(name = "dgrm_img_id")
//	private DgrmImageInfoTbl dgrmImgInfoTbl;
//
//	public DgrmImageInfoTbl getDgrmImgInfoTbl() {
//		return dgrmImgInfoTbl;
//	}
//
//	public void setDgrmImgInfoTbl(DgrmImageInfoTbl dgrmImgInfoTbl) {
//		this.dgrmImgInfoTbl = dgrmImgInfoTbl;
//	}


	@javax.persistence.Basic
	@ManyToOne(cascade = {CascadeType.DETACH},fetch = FetchType.EAGER)
	@JoinColumn(name = "quiz_id")
	private KiQuizeTbl quizInfoTbl;
	public KiQuizeTbl getQuizInfoTbl() {
		return quizInfoTbl;
	}

	public void setQuizInfoTbl(KiQuizeTbl quizInfoTbl) {
		this.quizInfoTbl = quizInfoTbl;
	}


	

	private String user_quest_name;
	

	private String user_quest_optionA;
	

	private String user_quest_optionB;
	

	private String user_quest_optionC;
	

	private String user_quest_optionD;
	

	private String user_quest_ans;
	

	private double user_quest_marks;

	public Long getUser_quest_id() {
		return user_quest_id;
	}

	public void setUser_quest_id(Long user_quest_id) {
		this.user_quest_id = user_quest_id;
	}


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
	

}

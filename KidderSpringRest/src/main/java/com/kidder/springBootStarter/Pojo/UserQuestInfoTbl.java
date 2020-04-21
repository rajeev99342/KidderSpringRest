package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_quest_info_tbl")
@Component
public class UserQuestInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_quest_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_txt_id" )
	private long user_quest_txt_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_img_id" )
	private long user_quest_img_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_dgrm_id" )
	private long user_quest_dgrm_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_id" )
	private long quiz_id;
	
	
	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_id" )
	private long user_id;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_name" )
	private String user_quest_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionA" )
	private String user_quest_optionA;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionB" )
	private String user_quest_optionB;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionC" )
	private String user_quest_optionC;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_optionD" )
	private String user_quest_optionD;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "user_quest_ans" )
	private String user_quest_ans;
	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "user_quest_creator")
	private String user_quest_creator;
	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "user_quest_marks")
	private double user_quest_marks;

	public Long getUser_quest_id() {
		return user_quest_id;
	}

	public void setUser_quest_id(Long user_quest_id) {
		this.user_quest_id = user_quest_id;
	}

	public long getUser_quest_txt_id() {
		return user_quest_txt_id;
	}

	public void setUser_quest_txt_id(long user_quest_txt_id) {
		this.user_quest_txt_id = user_quest_txt_id;
	}

	public long getUser_quest_img_id() {
		return user_quest_img_id;
	}

	public void setUser_quest_img_id(long user_quest_img_id) {
		this.user_quest_img_id = user_quest_img_id;
	}

	public long getUser_quest_dgrm_id() {
		return user_quest_dgrm_id;
	}

	public void setUser_quest_dgrm_id(long user_quest_dgrm_id) {
		this.user_quest_dgrm_id = user_quest_dgrm_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_quest_name() {
		return user_quest_name;
	}

	public void setUser_quest_name(String user_quest_name) {
		this.user_quest_name = user_quest_name;
	}

	public String getUser_quest_optionA() {
		return user_quest_optionA;
	}

	public void setUser_quest_optionA(String user_quest_optionA) {
		this.user_quest_optionA = user_quest_optionA;
	}

	public String getUser_quest_optionB() {
		return user_quest_optionB;
	}

	public void setUser_quest_optionB(String user_quest_optionB) {
		this.user_quest_optionB = user_quest_optionB;
	}

	public String getUser_quest_optionC() {
		return user_quest_optionC;
	}

	public void setUser_quest_optionC(String user_quest_optionC) {
		this.user_quest_optionC = user_quest_optionC;
	}

	public String getUser_quest_optionD() {
		return user_quest_optionD;
	}

	public void setUser_quest_optionD(String user_quest_optionD) {
		this.user_quest_optionD = user_quest_optionD;
	}

	public String getUser_quest_ans() {
		return user_quest_ans;
	}

	public void setUser_quest_ans(String user_quest_ans) {
		this.user_quest_ans = user_quest_ans;
	}

	public String getUser_quest_creator() {
		return user_quest_creator;
	}

	public void setUser_quest_creator(String user_quest_creator) {
		this.user_quest_creator = user_quest_creator;
	}

	public double getUser_quest_marks() {
		return user_quest_marks;
	}

	public void setUser_quest_marks(double user_quest_marks) {
		this.user_quest_marks = user_quest_marks;
	} 
	
}

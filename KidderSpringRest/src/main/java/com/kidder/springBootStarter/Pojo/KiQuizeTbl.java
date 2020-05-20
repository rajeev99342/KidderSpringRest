package com.kidder.springBootStarter.Pojo;

import java.sql.Time;
import java.sql.Timestamp;

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
@Table(name = "ki_quiz_tbl")

public class KiQuizeTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_id" )
	private long quiz_id;
	
	private String quiz_name;
	private int quiz_num_of_ques;

	private Timestamp quiz_created_date;
	private Timestamp quiz_published_date;
	private int quiz_duration;
	private double quiz_marks;
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_status" )
	private int quiz_status;

	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}



	public int getQuiz_status() {
		return quiz_status;
	}

	public void setQuiz_status(int quiz_status) {
		this.quiz_status = quiz_status;
	}



	@javax.persistence.Basic
	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name ="grp_id")
	private KiGroupTbl grpInfoTbl;

	public KiGroupTbl getGrpInfoTbl() {
		return grpInfoTbl;
	}

	public void setGrpInfoTbl(KiGroupTbl grpInfoTbl) {
		this.grpInfoTbl = grpInfoTbl;
	}
	
	
	@javax.persistence.Basic
	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name ="user_id")
	KiUserTbl userInfoTbl;

	public KiUserTbl getUserInfoTbl() {
		return userInfoTbl;
	}

	public void setUserInfoTbl(KiUserTbl userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_created_date" )
	public Timestamp getQuiz_created_date() {
		return quiz_created_date;
	}

	public void setQuiz_created_date(Timestamp quiz_created_date) {
		this.quiz_created_date = quiz_created_date;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_name" )
	public String getQuiz_name() {
		return quiz_name;
	}

	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}




	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_published_date" )
	public Timestamp getQuiz_published_date() {
		return quiz_published_date;
	}

	public void setQuiz_published_date(Timestamp quiz_published_date) {
		this.quiz_published_date = quiz_published_date;
	}
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_duration" )
	public int getQuiz_duration() {
		return quiz_duration;
	}

	public void setQuiz_duration(int quiz_duration) {
		this.quiz_duration = quiz_duration;
	}
	
	
	

	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_marks" )
	public double getQuiz_marks() {
		return quiz_marks;
	}

	public void setQuiz_marks(double quiz_marks) {
		this.quiz_marks = quiz_marks;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_num_of_ques" )
	public int getQuiz_num_of_ques() {
		return quiz_num_of_ques;
	}

	public void setQuiz_num_of_ques(int quiz_num_of_ques) {
		this.quiz_num_of_ques = quiz_num_of_ques;
	}

	
	
}

package com.kidder.springBootStarter.Pojo;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "quiz_info_tbl")
@Component
public class QuizeInfoTbl {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quiz_id;
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_name" )
	private String quiz_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_name" )
	private String grp_name;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_exam" )
	private String quiz_exam;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_sub" )
	private String quiz_sub;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_topic" )
	private String quiz_topic;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_created_date" )
	private Timestamp quiz_created_date;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_published_date" )
	private Timestamp quiz_published_date;
	
//	@javax.persistence.Basic
//	@javax.persistence.Column( name = "quiz_time" )
//	private Time quiz_time;
//	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_duration" )
	private int quiz_duration;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_creator" )
	private String quiz_creator;
	
	public Timestamp getQuiz_created_date() {
		return quiz_created_date;
	}

	public void setQuiz_created_date(Timestamp quiz_created_date) {
		this.quiz_created_date = quiz_created_date;
	}

	public String getQuiz_creator() {
		return quiz_creator;
	}

	public void setQuiz_creator(String quiz_creator) {
		this.quiz_creator = quiz_creator;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_marks" )
	private double quiz_marks;
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_num_of_ques" )
	private int quiz_num_of_ques;

	public Long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Long quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getQuiz_name() {
		return quiz_name;
	}

	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}

	public String getGrp_name() {
		return grp_name;
	}

	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}

	public String getQuiz_exam() {
		return quiz_exam;
	}

	public void setQuiz_exam(String quiz_exam) {
		this.quiz_exam = quiz_exam;
	}

	public String getQuiz_sub() {
		return quiz_sub;
	}

	public void setQuiz_sub(String quiz_sub) {
		this.quiz_sub = quiz_sub;
	}

	public String getQuiz_topic() {
		return quiz_topic;
	}

	public void setQuiz_topic(String quiz_topic) {
		this.quiz_topic = quiz_topic;
	}

	public Timestamp getQuiz_published_date() {
		return quiz_published_date;
	}

	public void setQuiz_published_date(Timestamp quiz_published_date) {
		this.quiz_published_date = quiz_published_date;
	}

	public int getQuiz_duration() {
		return quiz_duration;
	}

	public void setQuiz_duration(int quiz_duration) {
		this.quiz_duration = quiz_duration;
	}
	public double getQuiz_marks() {
		return quiz_marks;
	}

	public void setQuiz_marks(double quiz_marks) {
		this.quiz_marks = quiz_marks;
	}

	public int getQuiz_num_of_ques() {
		return quiz_num_of_ques;
	}

	public void setQuiz_num_of_ques(int quiz_num_of_ques) {
		this.quiz_num_of_ques = quiz_num_of_ques;
	}
	
	
}

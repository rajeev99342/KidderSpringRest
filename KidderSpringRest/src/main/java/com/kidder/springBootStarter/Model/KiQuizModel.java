package com.kidder.springBootStarter.Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
public class KiQuizModel extends CommonColumnModel {
	private long quiz_id;

	private String quiz_name;
	private int quiz_num_of_ques;
	private String quiz_exam;
	private String quiz_sub;
	private Timestamp quiz_created_date;
	private String quiz_topic;
	private Timestamp quiz_published_date;
	private int quiz_duration;
	private int quiz_status;
	private double quiz_marks;
	KiUserModel userModel;
	private KiGroupModel grpModel;
	
	public long getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}
	
	private String status;
	private String error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}
	public int getQuiz_num_of_ques() {
		return quiz_num_of_ques;
	}
	public void setQuiz_num_of_ques(int quiz_num_of_ques) {
		this.quiz_num_of_ques = quiz_num_of_ques;
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

	public int getQuiz_status() {
		return quiz_status;
	}
	public void setQuiz_status(int quiz_status) {
		this.quiz_status = quiz_status;
	}
	public void setQuiz_sub(String quiz_sub) {
		this.quiz_sub = quiz_sub;
	}
	public Timestamp getQuiz_created_date() {
		return quiz_created_date;
	}
	public void setQuiz_created_date(Timestamp quiz_created_date) {
		this.quiz_created_date = quiz_created_date;
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
	public KiUserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(KiUserModel userModel) {
		this.userModel = userModel;
	}
	public KiGroupModel getGrpModel() {
		return grpModel;
	}
	public void setGrpModel(KiGroupModel grpModel) {
		this.grpModel = grpModel;
	}

	
	

}
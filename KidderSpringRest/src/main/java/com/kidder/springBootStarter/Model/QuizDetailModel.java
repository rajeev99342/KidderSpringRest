package com.kidder.springBootStarter.Model;

import java.sql.Timestamp;
import java.util.List;

import com.kidder.springBootStarter.Pojo.KiQuizeTbl;

public class QuizDetailModel {
	
	KiQuizModel quizModel ;
	List<KiUserQuestionModel> questions;
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
	public List<KiUserQuestionModel> getQuestions() {
		return questions;
	}
	public void setQuestions(List<KiUserQuestionModel> questions) {
		this.questions = questions;
	}
	public KiQuizModel getQuizModel() {
		return quizModel;
	}
	public void setQuizModel(KiQuizModel quizModel) {
		this.quizModel = quizModel;
	}
	
	
	
}

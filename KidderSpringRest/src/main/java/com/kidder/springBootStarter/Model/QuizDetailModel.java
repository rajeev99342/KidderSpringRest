package com.kidder.springBootStarter.Model;

import java.sql.Timestamp;
import java.util.List;

import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;

public class QuizDetailModel {
	
	QuizModel quizModel ;
	List<UserQuestionModel> questions;
	
	public List<UserQuestionModel> getQuestions() {
		return questions;
	}
	public void setQuestions(List<UserQuestionModel> questions) {
		this.questions = questions;
	}
	public QuizModel getQuizModel() {
		return quizModel;
	}
	public void setQuizModel(QuizModel quizModel) {
		this.quizModel = quizModel;
	}
	
	
	
}

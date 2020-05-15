//package com.kidder.springBootStarter.Pojo;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//
//@Entity
//@Table(name = "quiz_question_map_tbl")
//@Component
//public class QuizeQuestionMapTbl {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long quiz_quest_map_info_id;
//	@javax.persistence.Basic
//	@javax.persistence.Column( name = "quiz_id" )
//	private long quiz_id;
//	
//	@javax.persistence.Basic
//	@javax.persistence.Column( name = "quest_id" )
//	private long quest_id;
//
//	public Long getQuiz_quest_map_info_id() {
//		return quiz_quest_map_info_id;
//	}
//
//	public void setQuiz_quest_map_info_id(Long quiz_quest_map_info_id) {
//		this.quiz_quest_map_info_id = quiz_quest_map_info_id;
//	}
//
//	public long getQuiz_id() {
//		return quiz_id;
//	}
//
//	public void setQuiz_id(long quiz_id) {
//		this.quiz_id = quiz_id;
//	}
//
//	public long getQuest_id() {
//		return quest_id;
//	}
//
//	public void setQuest_id(long quest_id) {
//		this.quest_id = quest_id;
//	}
//}

package com.kidder.springBootStarter.Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
public class KiQuizModel extends CommonColumnModel {
	private long quizId;

	private String quizName;
	private int quizNoOfQuest;
	private String quizSub;
	private Timestamp quizCreatedDate;
	private Timestamp quizPublishedDate;
	private int quizDuration;
	private String quizDesc;
	public String getQuizDesc() {
		return quizDesc;
	}
	public void setQuizDesc(String quizDesc) {
		this.quizDesc = quizDesc;
	}

	private int quizStatus;
	private double quizMarks;
	private KiUserModel userModel;
	private KiGroupModel grpModel;
	private Set<KiKidderQuestModel> kidderQuestModels;

	public long getquizId() {
		return quizId;
	}
	public void setquizId(long quizId) {
		this.quizId = quizId;
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
	public Set<KiKidderQuestModel> getKidderQuestModels() {
		return kidderQuestModels;
	}
	public void setKidderQuestModels(Set<KiKidderQuestModel> kidderQuestModels) {
		this.kidderQuestModels = kidderQuestModels;
	}
	public void setError(String error) {
		this.error = error;
	}

	public String getquizName() {
		return quizName;
	}
	public void setquizName(String quizName) {
		this.quizName = quizName;
	}
	public int getquizNoOfQuest() {
		return quizNoOfQuest;
	}
	public void setquizNoOfQuest(int quizNoOfQuest) {
		this.quizNoOfQuest = quizNoOfQuest;
	}

	public String getquizSub() {
		return quizSub;
	}

	public int getquizStatus() {
		return quizStatus;
	}
	public void setquizStatus(int quizStatus) {
		this.quizStatus = quizStatus;
	}
	public void setquizSub(String quizSub) {
		this.quizSub = quizSub;
	}
	public Timestamp getquizCreatedDate() {
		return quizCreatedDate;
	}
	public void setquizCreatedDate(Timestamp quizCreateDate) {
		this.quizCreatedDate = quizCreateDate;
	}

	public Timestamp getquizPublishedDate() {
		return quizPublishedDate;
	}
	public void setquizPublishedDate(Timestamp quizPublisheDate) {
		this.quizPublishedDate = quizPublisheDate;
	}
	public int getquizDuration() {
		return quizDuration;
	}
	public void setquizDuration(int quizDuration) {
		this.quizDuration = quizDuration;
	}
	public double getquizMarks() {
		return quizMarks;
	}
	public void setquizMarks(double quizMarks) {
		this.quizMarks = quizMarks;
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
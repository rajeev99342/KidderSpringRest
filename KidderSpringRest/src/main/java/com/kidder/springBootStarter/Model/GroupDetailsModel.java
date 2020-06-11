package com.kidder.springBootStarter.Model;

import java.util.ArrayList;
import java.util.List;

public class GroupDetailsModel {
	
	List<KiQuizModel> quizList ;
	List<KiUserModel> userList ;
	public List<KiQuizModel> getQuizList() {
		return quizList;
	}
	public void setQuizList(List<KiQuizModel> quizList) {
		this.quizList = quizList;
	}
	public List<KiUserModel> getUserList() {
		return userList;
	}
	public void setUserList(List<KiUserModel> userList) {
		this.userList = userList;
	}
	
}

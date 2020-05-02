package com.kidder.springBootStarter.Model;

import java.io.Serializable;

import com.kidder.springBootStarter.Pojo.DgrmImageInfoTbl;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Pojo.TxtQuesInfoTbl;

public class UserQuestionModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 686779788613888103L;
	private boolean isEdit;
	
	private long user_quest_id;
	private String user_quest_name;

	private double user_quest_marks;
	private String user_quest_optionA;
	private String user_quest_optionB;
	private String user_quest_optionC;
	private String user_quest_optionD;
	private String user_quest_ans;
	private QuizModel quizModel;
	private UserModel userModel;
	private ImageInfoModel imageInfoModel;
	private DgrmImageInfoModel dgrmImageInfoModel;
	private TxtQuesInfoModel txtQuesInfoModel;
	public QuizModel getQuizModel() {
		return quizModel;
	}
	public void setQuizModel(QuizModel quizModel) {
		this.quizModel = quizModel;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public void setDgrmImageInfoModel(DgrmImageInfoModel dgrmImageInfoModel) {
		this.dgrmImageInfoModel = dgrmImageInfoModel;
	}
	public void setTxtQuesInfoModel(TxtQuesInfoModel txtQuesInfoModel) {
		this.txtQuesInfoModel = txtQuesInfoModel;
	}

	
	public String getUser_quest_name() {
		return user_quest_name;
	}
	public void setUser_quest_name(String user_quest_name) {
		this.user_quest_name = user_quest_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getUser_quest_id() {
		return user_quest_id;
	}
	public void setUser_quest_id(long user_quest_id) {
		this.user_quest_id = user_quest_id;
	}

	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public double getUser_quest_marks() {
		return user_quest_marks;
	}
	public void setUser_quest_marks(double user_quest_marks) {
		this.user_quest_marks = user_quest_marks;
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

	public ImageInfoModel getImageInfoModel() {
		return imageInfoModel;
	}
	public void setImageInfoModel(ImageInfoModel imageInfoModel) {
		this.imageInfoModel = imageInfoModel;
	}
	
}

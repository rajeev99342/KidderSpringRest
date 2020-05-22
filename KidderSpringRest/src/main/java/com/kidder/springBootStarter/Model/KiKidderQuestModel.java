package com.kidder.springBootStarter.Model;


import java.util.Set;

import com.kidder.springBootStarter.Pojo.KiUserTbl;

public class KiKidderQuestModel extends CommonColumnModel{


    private Long ki_kidder_quest_id;

	private String ki_kidder_quest_name;
	
	private String ki_kidder_quest_optionA;
	
	private String ki_kidder_quest_optionB;
	
	private String ki_kidder_quest_optionC;
	
	private String ki_kidder_quest_optionD;
	private String ki_kidder_quest_sub;
	
	private String ki_kidder_quest_topic;

	private Integer ki_kidder_quest_level;
	
	private String ki_kidder_quest_ans;
	
	private Double ki_kidder_quest_marks;

	private KiUserModel userModel;

	private KiTxtQuesModel txtQuesInfoModel;
	
	private Set<DgrmImageInfoModel> dgrmImageInfoModels;
	
	private Boolean error;
	
	private String status;

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getKi_kidder_quest_id() {
		return ki_kidder_quest_id;
	}

	public Set<DgrmImageInfoModel> getDgrmImageInfoModels() {
		return dgrmImageInfoModels;
	}

	public void setDgrmImageInfoModels(Set<DgrmImageInfoModel> dgrmImageInfoModels) {
		this.dgrmImageInfoModels = dgrmImageInfoModels;
	}

	public void setKi_kidder_quest_id(Long ki_kidder_quest_id) {
		this.ki_kidder_quest_id = ki_kidder_quest_id;
	}

	public String getKi_kidder_quest_name() {
		return ki_kidder_quest_name;
	}

	public void setKi_kidder_quest_name(String ki_kidder_quest_name) {
		this.ki_kidder_quest_name = ki_kidder_quest_name;
	}

	public String getKi_kidder_quest_optionA() {
		return ki_kidder_quest_optionA;
	}

	public void setKi_kidder_quest_optionA(String ki_kidder_quest_optionA) {
		this.ki_kidder_quest_optionA = ki_kidder_quest_optionA;
	}

	public String getKi_kidder_quest_optionB() {
		return ki_kidder_quest_optionB;
	}

	public void setKi_kidder_quest_optionB(String ki_kidder_quest_optionB) {
		this.ki_kidder_quest_optionB = ki_kidder_quest_optionB;
	}

	public String getKi_kidder_quest_optionC() {
		return ki_kidder_quest_optionC;
	}

	public void setKi_kidder_quest_optionC(String ki_kidder_quest_optionC) {
		this.ki_kidder_quest_optionC = ki_kidder_quest_optionC;
	}

	public String getKi_kidder_quest_optionD() {
		return ki_kidder_quest_optionD;
	}

	public void setKi_kidder_quest_optionD(String ki_kidder_quest_optionD) {
		this.ki_kidder_quest_optionD = ki_kidder_quest_optionD;
	}



	public Integer getKi_kidder_quest_level() {
		return ki_kidder_quest_level;
	}

	public void setKi_kidder_quest_level(Integer ki_kidder_quest_level) {
		this.ki_kidder_quest_level = ki_kidder_quest_level;
	}

	public String getKi_kidder_quest_ans() {
		return ki_kidder_quest_ans;
	}

	public void setKi_kidder_quest_ans(String ki_kidder_quest_ans) {
		this.ki_kidder_quest_ans = ki_kidder_quest_ans;
	}

	public Double getKi_kidder_quest_marks() {
		return ki_kidder_quest_marks;
	}

	public void setKi_kidder_quest_marks(Double ki_kidder_quest_marks) {
		this.ki_kidder_quest_marks = ki_kidder_quest_marks;
	}


	public KiUserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(KiUserModel userModel) {
		this.userModel = userModel;
	}

	public KiTxtQuesModel getTxtQuesInfoModel() {
		return txtQuesInfoModel;
	}

	public void setTxtQuesInfoModel(KiTxtQuesModel txtQuesInfoModel) {
		this.txtQuesInfoModel = txtQuesInfoModel;
	}

	public String getKi_kidder_quest_sub() {
		return ki_kidder_quest_sub;
	}

	public void setKi_kidder_quest_sub(String ki_kidder_quest_sub) {
		this.ki_kidder_quest_sub = ki_kidder_quest_sub;
	}

	public String getKi_kidder_quest_topic() {
		return ki_kidder_quest_topic;
	}

	public void setKi_kidder_quest_topic(String ki_kidder_quest_topic) {
		this.ki_kidder_quest_topic = ki_kidder_quest_topic;
	}


	
}

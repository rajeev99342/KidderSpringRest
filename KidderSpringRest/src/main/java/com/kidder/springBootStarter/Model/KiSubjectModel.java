package com.kidder.springBootStarter.Model;

import com.kidder.springBootStarter.Pojo.KiTopicTbl;

public class KiSubjectModel {
    private Long ki_sub_id;
	private String ki_sub_code;
	private String ki_sub_name;
	private KiTopicTbl kiTopicTbl;
	public Long getKi_sub_id() {
		return ki_sub_id;
	}
	public void setKi_sub_id(Long ki_sub_id) {
		this.ki_sub_id = ki_sub_id;
	}
	public String getKi_sub_code() {
		return ki_sub_code;
	}
	public void setKi_sub_code(String ki_sub_code) {
		this.ki_sub_code = ki_sub_code;
	}
	public String getKi_sub_name() {
		return ki_sub_name;
	}
	public void setKi_sub_name(String ki_sub_name) {
		this.ki_sub_name = ki_sub_name;
	}
	public KiTopicTbl getKiTopicTbl() {
		return kiTopicTbl;
	}
	public void setKiTopicTbl(KiTopicTbl kiTopicTbl) {
		this.kiTopicTbl = kiTopicTbl;
	}

}

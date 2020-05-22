package com.kidder.springBootStarter.Model;

public class KiTxtQuesModel extends CommonColumnModel{

	private long txt_ques_id;
	private String quesTxt;
	public long getTxt_ques_id() {
		return txt_ques_id;
	}
	public void setTxt_ques_id(long txt_ques_id) {
		this.txt_ques_id = txt_ques_id;
	}
	public String getQuesTxt() {
		return quesTxt;
	}
	public void setQuesTxt(String quesTxt) {
		this.quesTxt = quesTxt;
	}
	
	
}

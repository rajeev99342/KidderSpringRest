package com.kidder.springBootStarter.Model;

public class KiTopicModel {
    private Long ki_topic_id;
	private String ki_topic_name;
	private String ki_sub_code;
	public Long getKi_topic_id() {
		return ki_topic_id;
	}
	public void setKi_topic_id(Long ki_topic_id) {
		this.ki_topic_id = ki_topic_id;
	}
	public String getKi_topic_name() {
		return ki_topic_name;
	}
	public void setKi_topic_name(String ki_topic_name) {
		this.ki_topic_name = ki_topic_name;
	}
	public String getKi_sub_code() {
		return ki_sub_code;
	}
	public void setKi_sub_code(String ki_sub_code) {
		this.ki_sub_code = ki_sub_code;
	}

}

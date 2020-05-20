package com.kidder.springBootStarter.Model;

import java.util.Set;

import com.kidder.springBootStarter.Pojo.ChildTbl;

public class ParentModel {
	private String parent_name;
	
	private Set<ChildModel> childs;

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public Set<ChildModel> getChilds() {
		return childs;
	}

	public void setChilds(Set<ChildModel> childs) {
		this.childs = childs;
	}
	
	
}

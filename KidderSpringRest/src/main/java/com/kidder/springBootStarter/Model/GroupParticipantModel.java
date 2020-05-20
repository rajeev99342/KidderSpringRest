package com.kidder.springBootStarter.Model;



import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;

public class GroupParticipantModel {


    private Long grp_part_id;
	

    private KiGroupModel groupModel;

    private KiUserModel userModel;

	private Integer isAdmin;
	
	private String  status;
	
	private String  error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getGrp_part_id() {
		return grp_part_id;
	}

	public void setGrp_part_id(Long grp_part_id) {
		this.grp_part_id = grp_part_id;
	}



	public KiGroupModel getGroupModel() {
		return groupModel;
	}

	public void setGroupModel(KiGroupModel groupModel) {
		this.groupModel = groupModel;
	}

	public KiUserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(KiUserModel userModel) {
		this.userModel = userModel;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}


	
}

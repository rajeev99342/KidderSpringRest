package com.kidder.springBootStarter.Model;



import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;

public class GroupParticipantModel {


    private Long grp_part_id;
	

    private GroupModel groupModel;

    private UserModel userModel;

	private Integer isAdmin;

	public Long getGrp_part_id() {
		return grp_part_id;
	}

	public void setGrp_part_id(Long grp_part_id) {
		this.grp_part_id = grp_part_id;
	}



	public GroupModel getGroupModel() {
		return groupModel;
	}

	public void setGroupModel(GroupModel groupModel) {
		this.groupModel = groupModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}


	
}

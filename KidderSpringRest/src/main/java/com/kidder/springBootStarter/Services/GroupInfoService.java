package com.kidder.springBootStarter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Repo.GroupInfoRepository;

@Repository
public class GroupInfoService {
@Autowired
GroupInfoRepository groupInfoRepository;

@Autowired
GroupInfoTbl groupInfoTbl;

public String saveGroupDetail(GroupModel groupModel){
	if(groupInfoRepository.getGroupDetailsByGroupName(groupModel.getGrp_name()).size() ==0) {
		if(groupModel.getGrp_unique_code() == null) {
			groupModel.setGrp_unique_code(CommonResource.randomString((20 - groupModel.getGrp_name().length())) + groupModel.getGrp_name().toUpperCase());
		}
		SetParams(groupModel);
		groupInfoRepository.save(groupInfoTbl);
	} else {
		return "Group Name Alredy Exist";
	}
	return "Group created Succesfully";
	
}

public void SetParams(GroupModel groupModel) {
	groupInfoTbl.setGrp_id(groupModel.getGrp_id());
	groupInfoTbl.setGrp_name(groupModel.getGrp_name());
	groupInfoTbl.setGrp_admin(groupModel.getGrp_admin());
	groupInfoTbl.setGrp_desc(groupModel.getGrp_desc());
	groupInfoTbl.setGrp_unique_code(groupModel.getGrp_unique_code());
}
}


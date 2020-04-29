package com.kidder.springBootStarter.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Repo.GroupInfoRepository;

@Service
public class GroupInfoService {
@Autowired
GroupInfoRepository groupInfoRepository;
@Autowired 
UserInfoService userService;

@Autowired
UserGrpService userGroupService;



public GroupModel saveGroupDetail(GroupModel groupModel){
	if(groupInfoRepository.getGroupDetailsByGroupName(groupModel.getGrp_name()).size() ==0) {
		if(groupModel.getGrp_unique_code() == null) {
			groupModel.setGrp_unique_code(CommonResource.randomString((20 - groupModel.getGrp_name().length())) + groupModel.getGrp_name().toUpperCase());
		}
		GroupInfoTbl groupInfoTbl = SetParams(groupModel);
		GroupModel groupModel1 = new GroupModel();

		try {
			
			groupInfoTbl =	groupInfoRepository.save(groupInfoTbl);
			
			

		}catch (Exception e) {

			// TODO: handle exception
			groupModel1.setError(e.getMessage());
			groupModel1.setStatus("Failed");
		}
		
		return groupModel;
	} else {
		GroupModel groupModel1 = new GroupModel();

		groupModel1.setError("Group Name Alredy Exist");
		groupModel1.setStatus("Failed");
		return groupModel1;
	}
	
	
	
}

public GroupInfoTbl SetParams(GroupModel groupModel) {
	GroupInfoTbl groupInfoTbl = new GroupInfoTbl();

			groupInfoTbl.setGrp_id(groupModel.getGrp_id());
			groupInfoTbl.setGrp_name(groupModel.getGrp_name());
			groupInfoTbl.setGrp_admin(groupModel.getGrp_admin());
			groupInfoTbl.setGrp_desc(groupModel.getGrp_desc());
			groupInfoTbl.setGrp_unique_code(groupModel.getGrp_unique_code());
			return groupInfoTbl;
	}
	
	public Set<GroupModel> getGrpByAdmin(String username,Boolean isMyGroup)
	{
		
		  Set<GroupModel> models = new HashSet<GroupModel>();

		
	  try {
		  Set<GroupInfoTbl> tbls = new HashSet<GroupInfoTbl>();
//		  List<GroupInfoTbl> tbls2 = new ArrayList<GroupInfoTbl>();
		  if(isMyGroup)
		  {
			  tbls =	groupInfoRepository.getGrpByAdmin(username);
		  }else {
			  tbls = groupInfoRepository.getAllGrp();
		  }
		

		  for(GroupInfoTbl t : tbls)
		  {
			  if(isMyGroup)
			  {
				  GroupModel model = new GroupModel();
				  model.setError(null);
				  model.setGrp_admin(t.getGrp_admin());
				  model.setGrp_desc(t.getGrp_desc());
				  model.setGrp_id(t.getGrp_id());
				  model.setGrp_name(t.getGrp_name());
				  model.setGrp_unique_code(t.getGrp_unique_code());
				  model.setStatus("Success");
				  models.add(model);	  
			  }else if(!isMyGroup && t.getGrp_admin() != null &&  !t.getGrp_admin().equals(username))
			  {
				  GroupModel model = new GroupModel();
				  model.setError(null);
				  model.setGrp_admin(t.getGrp_admin());
				  model.setGrp_desc(t.getGrp_desc());
				  model.setGrp_id(t.getGrp_id());
				  model.setGrp_name(t.getGrp_name());
				  model.setGrp_unique_code(t.getGrp_unique_code());
				  model.setStatus("Success");
				  models.add(model);	
			  }

		  }
			
	  }catch (Exception e) {
		// TODO: handle exception
		  
		  return null;
	}
	  
	  return models;
}
	
	
	public List<GroupModel> getAllGrp(String username)
	{
		try
		{
			List<GroupInfoTbl> grpList = groupInfoRepository.findAll();
			
			List<GroupModel> groupList = new ArrayList<GroupModel>();
			
			for(GroupInfoTbl tbl : grpList)
			{
				if(tbl.getGrp_admin() != username)
				{
					GroupModel model = new GroupModel();
					UserModel userModel = new UserModel();
					model.setGrp_admin(tbl.getGrp_admin());
					model.setGrp_desc(tbl.getGrp_desc());
					model.setGrp_id(tbl.getGrp_id());
					model.setGrp_name(tbl.getGrp_name());
					model.setGrp_unique_code(tbl.getGrp_unique_code());
					model.setStatus("Success");
					model.setError(null);
					groupList.add(model);
				}

			}
			return groupList;
		}catch (Exception e) {
			return null;
		}
		
		
	}

}


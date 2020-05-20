package com.kidder.springBootStarter.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.KiGroupModel;
import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Repo.GroupInfoRepository;

@Service
public class GroupInfoService {
@Autowired
GroupInfoRepository groupInfoRepository;
@Autowired 
UserInfoService userService;

@Autowired
UserGrpService userGroupService;

@Autowired
GroupParticipantService grpPartiService;



public KiGroupModel saveGroupDetail(KiGroupModel groupModel){
	if(groupInfoRepository.getGroupDetailsByGroupName(groupModel.getGrp_name()).size() ==0) {
	
		KiGroupTbl groupInfoTbl = SetParams(groupModel);
		KiGroupModel groupModel1 = new KiGroupModel();

		try {
			
			groupInfoTbl =	groupInfoRepository.save(groupInfoTbl);
			
			GroupParticipantModel grpPartiModel = new GroupParticipantModel();
			
			groupModel = null;
			
			groupModel = ConvertedHelper.getGroupModel(groupInfoTbl);
			
			grpPartiModel.setGroupModel(groupModel);
			
			grpPartiModel.setIsAdmin(1);
			
			KiUserModel userModel =  userService.getUser(groupInfoTbl.getGrp_admin());
			
			grpPartiModel.setUserModel(userModel);
			
			grpPartiService.addParticipant(grpPartiModel,"Admin");
			
			groupModel = null;
			
			groupModel = ConvertedHelper.getGroupModel(groupInfoTbl);
			
			groupModel.setError(null);
			
			groupModel.setStatus("Sucess");
			

		}catch (Exception e) {

			// TODO: handle exception
			groupModel1.setError(e.getMessage());
			groupModel1.setStatus("Failed");
		}
		
		return groupModel;
	} else {
		KiGroupModel groupModel1 = new KiGroupModel();

		groupModel1.setError("Group Name Alredy Exist");
		groupModel1.setStatus("Failed");
		return groupModel1;
	}
	
	
	
}

public KiGroupTbl SetParams(KiGroupModel groupModel) {
	KiGroupTbl groupInfoTbl = new KiGroupTbl();

			groupInfoTbl.setGrp_id(groupModel.getGrp_id());
			groupInfoTbl.setGrp_name(groupModel.getGrp_name());
			groupInfoTbl.setGrp_admin(groupModel.getGrp_admin());
			groupInfoTbl.setGrp_desc(groupModel.getGrp_desc());
			return groupInfoTbl;
	}
	
	public Set<KiGroupModel> getGrpByAdmin(String username,Boolean isMyGroup)
	{
		
		  Set<KiGroupModel> models = new HashSet<KiGroupModel>();

		
	  try {
		  Set<KiGroupTbl> tbls = new HashSet<KiGroupTbl>();
//		  List<GroupInfoTbl> tbls2 = new ArrayList<GroupInfoTbl>();
		  if(isMyGroup)
		  {
			  tbls =	groupInfoRepository.getGrpByAdmin(username);
		  }else {
			  tbls = groupInfoRepository.getAllGrp();
		  }
		

		  for(KiGroupTbl t : tbls)
		  {
			  if(isMyGroup)
			  {
				  KiGroupModel model = new KiGroupModel();
				  model.setError(null);
				  model.setGrp_admin(t.getGrp_admin());
				  model.setGrp_desc(t.getGrp_desc());
				  model.setGrp_id(t.getGrp_id());
				  model.setGrp_name(t.getGrp_name());
				  model.setStatus("Success");
				  models.add(model);	  
			  }else if(!isMyGroup && t.getGrp_admin() != null &&  !t.getGrp_admin().equals(username))
			  {
				  KiGroupModel model = new KiGroupModel();
				  model.setError(null);
				  model.setGrp_admin(t.getGrp_admin());
				  model.setGrp_desc(t.getGrp_desc());
				  model.setGrp_id(t.getGrp_id());
				  model.setGrp_name(t.getGrp_name());
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
	
	
	public List<KiGroupModel> getAllGrp(String username)
	{
		try
		{
			List<KiGroupTbl> grpList = groupInfoRepository.findAll();
			
			List<KiGroupModel> groupList = new ArrayList<KiGroupModel>();
			
			for(KiGroupTbl tbl : grpList)
			{
				if(tbl.getGrp_admin() != username)
				{
					KiGroupModel model = new KiGroupModel();
					KiUserModel userModel = new KiUserModel();
					model.setGrp_admin(tbl.getGrp_admin());
					model.setGrp_desc(tbl.getGrp_desc());
					model.setGrp_id(tbl.getGrp_id());
					model.setGrp_name(tbl.getGrp_name());
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

	
	public Set<KiGroupModel> getGrpsByUserId(long user_id)
	{
	     Set<KiGroupTbl> tbls = groupInfoRepository.getGrpByUserId(user_id);
	     Set<KiGroupModel> models = new HashSet<>();
	     
	     for(KiGroupTbl tbl : tbls)
	     {
	    	 KiGroupModel m = new KiGroupModel();
	    	 
	    	 m.setError(null);
	    	 m.setStatus("Success");
	    	 m.setGrp_admin(tbl.getGrp_admin());
	    	 m.setGrp_desc(tbl.getGrp_desc());
	    	 m.setGrp_id(tbl.getGrp_id());
	    	 m.setGrp_name(tbl.getGrp_name());
	    	 models.add(m);
	    	 
	     }
	     return models;
	}
	
	
}


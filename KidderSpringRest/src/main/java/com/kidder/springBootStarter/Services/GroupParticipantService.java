package com.kidder.springBootStarter.Services;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.kidder.Common.CheckTable;
import com.kidder.Common.CommonResource;
import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.KiGroupModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiGroupParticipantTbl;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiGrpReqstTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Repo.GroupParticipantRepository;

@Service
public class GroupParticipantService {

	@Autowired
	GroupParticipantRepository grpPartiRepo;
	@Autowired
	UserInfoService userService;
	
	
	public GroupParticipantModel addParticipant(GroupParticipantModel grpPartiModel,String userType)
	{
		
		
		GroupParticipantModel model = new GroupParticipantModel();
		KiGroupParticipantTbl tempTbl = new KiGroupParticipantTbl();
		
		try {
			KiGroupParticipantTbl grpPartiTbl = new KiGroupParticipantTbl();

			if(grpPartiModel.getUniqueCode() != null)
			{
				
			}else {
				grpPartiTbl.generateId();
				grpPartiTbl.setUniqueCode(GenerateUniqueCode.Generate(grpPartiTbl.getGrp_part_id(),"kgptbl"));
			}
			
			
			grpPartiTbl.setGroupInfoTbl(this.getGroupTbl(grpPartiModel.getGroupModel()));
			
			grpPartiTbl.setUserInfoTb(this.getUserTbl(grpPartiModel.getUserModel()));
			
			if(userType.equals("Participant"))
			{
				grpPartiTbl.setIsAdmin(false);
			}else if(userType.equals("Admin"))
			{
				grpPartiTbl.setIsAdmin(true);
			}
			
			
			
		
				if(userType.equals("Participant"))
				{
					KiGroupParticipantTbl tbl = grpPartiRepo.getParticipantByGrpIdandUserId(grpPartiModel.getUserModel().getUser_id(),grpPartiModel.getGroupModel().getGrp_id());

					if(tbl != null)
					{
						model.setError("user already added to you group");
						model.setStatus("Failure");
					}else {
					    tempTbl = grpPartiRepo.save(grpPartiTbl);

					}
					
				}else {
				    tempTbl = grpPartiRepo.save(grpPartiTbl);

				}
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			model.setError(e.getMessage());
			model.setStatus("Failure");
		}
		
		if(model.getStatus() == "Failure")
		{
			return model;
		}else {
			return null;

		}
//		
		
	}
	
	KiGroupTbl getGroupTbl(KiGroupModel model)
	{
		KiGroupTbl tbl = new KiGroupTbl();
		
		tbl.setGrp_admin(model.getGrp_admin());
		tbl.setGrp_desc(model.getGrp_desc());
		tbl.setGrp_id(model.getGrp_id());
		tbl.setGrp_name(model.getGrp_name());
		tbl.setDeleteFl(model.getDeleteFl());
		tbl.setUniqueCode(model.getUniqueCode());
		return tbl;
		
	}
	
	KiUserTbl getUserTbl(KiUserModel model)
	{
		KiUserTbl tbl = new KiUserTbl();
		tbl.setDeleteFl(model.getDeleteFl());
		tbl.setUser_id(model.getUser_id());
		tbl.setUniqueCode(model.getUniqueCode());
		tbl.setUser_email(model.getUser_email());
		tbl.setUser_name(model.getUser_name());
		tbl.setUser_password(model.getUser_password());
		tbl.setUser_phone_number(model.getUser_phone_number());
		tbl.setUser_username(model.getUser_username());
		tbl.setUser_token(model.getUser_token());
		return tbl;
	}
	
	public List<KiGroupParticipantTbl> getUserByGroupId(long grpId)
	{
		return grpPartiRepo.getUserByGroupId(grpId);
		
		
	}
	
	
}

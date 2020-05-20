package com.kidder.springBootStarter.Services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.kidder.Common.CheckTable;
import com.kidder.Common.CommonResource;
import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiGroupParticipantTbl;
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
		
//		UserModel grpAdmin = userService.getUser(grpPartiModel.getGroupModel().getGrp_admin());
		
		GroupParticipantModel model = new GroupParticipantModel();
		KiGroupParticipantTbl tempTbl = new KiGroupParticipantTbl();
//		UserInfoTbl grpAdminTbl = ConvertedHelper.getUserTbl(grpAdmin);
		
		try {
			
			KiGroupParticipantTbl grpPartiTbl = new KiGroupParticipantTbl();
			
			grpPartiTbl.setGroupInfoTbl(ConvertedHelper.getGroupTbl(grpPartiModel.getGroupModel()));
			
			grpPartiTbl.setUserInfoTb(ConvertedHelper.getUserTbl(grpPartiModel.getUserModel()));
			
			if(userType.equals("Participant"))
			{
				grpPartiTbl.setIsAdmin(0);
			}else if(userType.equals("Admin"))
			{
				grpPartiTbl.setIsAdmin(1);
			}
			
			
			
			if(CheckTable.isTableExist("grp_part_tbl"))
			{
				
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
				
			
			}else {
				 tempTbl = grpPartiRepo.save(grpPartiTbl);
			}
			

			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		if(model.getStatus() == "Failure")
		{
			return model;
		}else {
			return ConvertedHelper.getGroupParticipantModel(tempTbl);

		}
		
		
	}
	
	
}

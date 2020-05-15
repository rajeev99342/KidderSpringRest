package com.kidder.springBootStarter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CheckTable;
import com.kidder.Common.CommonResource;
import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.GroupParticipantTbl;
import com.kidder.springBootStarter.Pojo.GrpReqstTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Repo.GroupParticipantRepository;

@Service
public class GroupParticipantService {

	@Autowired
	GroupParticipantRepository grpPartiRepo;
	@Autowired
	UserInfoService userService;
	
	public GroupParticipantModel addParticipant(GroupParticipantModel grpPartiModel)
	{
		
		UserModel grpAdmin = userService.getUser(grpPartiModel.getGroupModel().getGrp_admin());
		
		GroupParticipantModel model = new GroupParticipantModel();
		GroupParticipantTbl tempTbl = new GroupParticipantTbl();
		UserInfoTbl grpAdminTbl = ConvertedHelper.getUserTbl(grpAdmin);
		
		try {
			
			GroupParticipantTbl grpPartiTbl = new GroupParticipantTbl();
			
			grpPartiTbl.setGroupInfoTbl(ConvertedHelper.getGroupTbl(grpPartiModel.getGroupModel()));
			
			grpPartiTbl.setUserInfoTb(grpAdminTbl);
			
			grpPartiTbl.setIsAdmin(1);
			
			if(CheckTable.isTableExist("grp_part_tbl"))
			{
				GroupParticipantTbl tbl = grpPartiRepo.getByGrpAdminId(grpAdminTbl.getUser_id());
				
				if(tbl == null)
				{
					 tempTbl = grpPartiRepo.save(grpPartiTbl);
				}
				
			}else {
				 tempTbl = grpPartiRepo.save(grpPartiTbl);
			}
			
			
		
			
			
			
			grpPartiTbl = new GroupParticipantTbl();
			
			grpPartiTbl.setGroupInfoTbl(ConvertedHelper.getGroupTbl(grpPartiModel.getGroupModel()));
			
			grpPartiTbl.setUserInfoTb(ConvertedHelper.getUserTbl(grpPartiModel.getUserModel()));
			
			
			tempTbl = null;
			
			grpPartiTbl.setIsAdmin(0);

			
			  tempTbl = grpPartiRepo.save(grpPartiTbl);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return ConvertedHelper.getGroupParticipantModel(tempTbl);
		
	}
	
	
}

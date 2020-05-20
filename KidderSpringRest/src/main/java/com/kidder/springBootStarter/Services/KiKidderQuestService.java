package com.kidder.springBootStarter.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.ConvertedHelper;
import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
import com.kidder.springBootStarter.Model.KiKidderQuestModel;
import com.kidder.springBootStarter.Model.KidderQuestionModel;
import com.kidder.springBootStarter.Model.KiTxtQuesInfoModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Pojo.KiSubjectTbl;
import com.kidder.springBootStarter.Pojo.KiTxtQuestTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Repo.KiKidderQuestRepository;

@Service
public class KiKidderQuestService {
	@Autowired
	KiKidderQuestRepository kiKidderQuestRepo;
	@Autowired
	DgrmImageService dgrmService;
	@Autowired
	UserInfoService userService;
	@Autowired
	KiSubjectService kiSubService;
	
	@Autowired 
	TxtQuestionService txtQuestService;
	
	 public KiKidderQuestModel saveQuestionByAdmin(KiKidderQuestModel kidderQuestModel) throws SQLException
	 {
		 
		 KiKidderQuestModel kidderModel = new KiKidderQuestModel();
		 KiKidderQuestTbl kiKidderQuestTbl = new KiKidderQuestTbl();
		 if(kidderQuestModel != null)
		 {
			 
			 if(kidderQuestModel.getUniqueCode() != null)
			 {
				 
			 }else {
				 kiKidderQuestTbl.generateId();
				 kiKidderQuestTbl.setUniqueCode(GenerateUniqueCode.Generate(kiKidderQuestTbl.getKi_kidder_quest_id(), "Ki_kidder_quest"));
				 kiKidderQuestTbl.setKi_kidder_quest_id(kiKidderQuestTbl.getId());
			 }
			 
			 kiKidderQuestTbl.setUserInfoTbl(userService.saveByModel(kidderQuestModel.getUserModel()));

			 kiKidderQuestTbl.setKi_kidder_quest_ans(kidderQuestModel.getKi_kidder_quest_ans());
			 kiKidderQuestTbl.setKi_kidder_quest_level(kidderQuestModel.getKi_kidder_quest_level());
			 kiKidderQuestTbl.setKi_kidder_quest_marks(kidderQuestModel.getKi_kidder_quest_marks());
			 kiKidderQuestTbl.setKi_kidder_quest_name(kidderQuestModel.getKi_kidder_quest_name());
			 kiKidderQuestTbl.setKi_kidder_quest_optionA(kidderQuestModel.getKi_kidder_quest_optionA());
			 kiKidderQuestTbl.setKi_kidder_quest_optionB(kidderQuestModel.getKi_kidder_quest_optionB());
			 kiKidderQuestTbl.setKi_kidder_quest_sub(kidderQuestModel.getKi_kidder_quest_sub());
			 kiKidderQuestTbl.setKi_kidder_quest_topic(kidderQuestModel.getKi_kidder_quest_topic());
			 kiKidderQuestTbl.setKi_kidder_quest_optionC(kidderQuestModel.getKi_kidder_quest_optionC());
			 kiKidderQuestTbl.setKi_kidder_quest_optionD(kidderQuestModel.getKi_kidder_quest_optionD());
			 kiKidderQuestTbl.setTxtQuesInfoTbl(txtQuestService.saveTxtQuestByModel(kidderQuestModel.getTxtQuesInfoModel()));
			
			 kiKidderQuestTbl.setDgrmImgInfoTbls(dgrmService.saveAllDgrm(kidderQuestModel.getDgrmImageInfoModels(),kiKidderQuestTbl));

			KiKidderQuestTbl kiKidderQuesTbl = kiKidderQuestRepo.save(kiKidderQuestTbl);


			kidderModel = ConvertedHelper.getKidderQuestModel(kiKidderQuesTbl);
		 }
		 return kidderModel;
	 }

	 public List<KidderQuestionModel> getKidderQuestion(KiUserModel user,Integer level)
	 {
		 
		List<KiKidderQuestTbl> kidderQuests = kiKidderQuestRepo.getKidderQuestByLevel(user.getUser_username(),level);
		
		for(KiKidderQuestTbl kikidderQ : kidderQuests)
		{
			List<KiDgrmImgTbl> dgrms = dgrmService.getDgrmByKidderQuestId(kikidderQ.getKi_kidder_quest_id());
			
			for(KiDgrmImgTbl dgrm : dgrms)
			{
				
			}
			
		}
		
		return null;
		 
	 }
	 
}
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
import com.kidder.springBootStarter.Model.KiTxtQuesModel;
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
	
	 public KiKidderQuestTbl saveQuestionByAdmin(KiKidderQuestModel kidderQuestModel) throws SQLException
	 {
		 
		 KiKidderQuestModel kidderModel = new KiKidderQuestModel();
		 KiKidderQuestTbl kiKidderQuestTbl = new KiKidderQuestTbl();
	
			 
			 if(kidderQuestModel.getUniqueCode() != null)
			 {
				 kiKidderQuestTbl = kiKidderQuestRepo.getByUniqueCode(kidderQuestModel.getUniqueCode());
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
			 kiKidderQuestTbl.setDeleteFl(false);
			 kiKidderQuestTbl.setDgrmImgInfoTbls(dgrmService.saveAllDgrm(kidderQuestModel.getDgrmImageInfoModels(),kiKidderQuestTbl));

			return kiKidderQuestRepo.save(kiKidderQuestTbl);


		
		 
		
	 }

	 public Set<KiKidderQuestModel> getQuestionByAdmin(String user_username) throws Exception
	 {
		 
		List<KiKidderQuestTbl> kidderQuests = kiKidderQuestRepo.getQuestionByAdmin(user_username);
		Set<KiKidderQuestModel> kidderQuestModels  = new HashSet<>();
		Set<DgrmImageInfoModel> dgrmModels = new HashSet<>();
		DgrmImageInfoModel dgrmModel = new DgrmImageInfoModel();
		
		for(KiKidderQuestTbl kikidderQ : kidderQuests)
		{
			KiKidderQuestModel questModel = new KiKidderQuestModel();
			
			questModel.setDgrmImageInfoModels(dgrmService.getDgrmModels(kikidderQ.getDgrmImgInfoTbls()));
			questModel.setDeleteFl(kikidderQ.getDeleteFl());
			questModel.setError(false);
			questModel.setStatus("Success");
			questModel.setKi_kidder_quest_ans(kikidderQ.getKi_kidder_quest_ans());
			questModel.setKi_kidder_quest_id(kikidderQ.getKi_kidder_quest_id());
			questModel.setKi_kidder_quest_level(kikidderQ.getKi_kidder_quest_level());
			questModel.setKi_kidder_quest_marks(kikidderQ.getKi_kidder_quest_marks());
			questModel.setKi_kidder_quest_name(kikidderQ.getKi_kidder_quest_name());
			questModel.setKi_kidder_quest_optionA(kikidderQ.getKi_kidder_quest_optionA());
			questModel.setKi_kidder_quest_optionB(kikidderQ.getKi_kidder_quest_optionB());
			questModel.setKi_kidder_quest_optionC(kikidderQ.getKi_kidder_quest_optionB());
			questModel.setKi_kidder_quest_optionD(kikidderQ.getKi_kidder_quest_optionD());
			questModel.setKi_kidder_quest_sub(kikidderQ.getKi_kidder_quest_sub());
			questModel.setKi_kidder_quest_topic(kikidderQ.getKi_kidder_quest_topic());
			questModel.setUniqueCode(kikidderQ.getUniqueCode());
			questModel.setTxtQuesInfoModel(txtQuestService.getTxtQuestModel(kikidderQ.getTxtQuesInfoTbl()));
//			Set<KiDgrmImgTbl> questDgrms = kikidderQ.getDgrmImgInfoTbls(); 
			kidderQuestModels.add(questModel);
			
			
		}
		
		return kidderQuestModels;
		 
	 }
	 
}

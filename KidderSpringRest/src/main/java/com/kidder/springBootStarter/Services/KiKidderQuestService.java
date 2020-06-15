package com.kidder.springBootStarter.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.kidder.springBootStarter.Repo.TxtQuestionRepository;

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
	@Autowired
	TxtQuestionService txtService;

	public KiKidderQuestTbl saveQuestionByAdmin(KiKidderQuestModel kidderQuestModel) throws SQLException {

		KiKidderQuestModel kidderModel = new KiKidderQuestModel();
		KiKidderQuestTbl kiKidderQuestTbl = new KiKidderQuestTbl();

		if (kidderQuestModel.getUniqueCode() != null) {
			kiKidderQuestTbl = kiKidderQuestRepo.getByUniqueCode(kidderQuestModel.getUniqueCode());
		} else {
			kiKidderQuestTbl.generateId();
			kiKidderQuestTbl.setUniqueCode(GenerateUniqueCode.Generate(kiKidderQuestTbl.getkqId(), "Ki_kidder_quest"));
			kiKidderQuestTbl.setkqId(kiKidderQuestTbl.getId());
		}

		kiKidderQuestTbl.setUserInfoTbl(userService.saveByModel(kidderQuestModel.getUserModel()));

		kiKidderQuestTbl.setkqAns(kidderQuestModel.getKi_kidder_quest_ans());
		kiKidderQuestTbl.setkqLvl(kidderQuestModel.getKi_kidder_quest_level());
		kiKidderQuestTbl.setkqMarks(kidderQuestModel.getKi_kidder_quest_marks());
		kiKidderQuestTbl.setkqName(kidderQuestModel.getKi_kidder_quest_name());
		kiKidderQuestTbl.setkqOptionA(kidderQuestModel.getKi_kidder_quest_optionA());
		kiKidderQuestTbl.setkqOptionB(kidderQuestModel.getKi_kidder_quest_optionB());
		kiKidderQuestTbl.setkqSub(kidderQuestModel.getKi_kidder_quest_sub());
		kiKidderQuestTbl.setkqTopic(kidderQuestModel.getKi_kidder_quest_topic());
		kiKidderQuestTbl.setkqOptionC(kidderQuestModel.getKi_kidder_quest_optionC());
		kiKidderQuestTbl.setkqOptionD(kidderQuestModel.getKi_kidder_quest_optionD());
		kiKidderQuestTbl.setTxtQuesInfoTbl(txtQuestService.saveTxtQuestByModel(kidderQuestModel.getTxtQuesInfoModel()));
		kiKidderQuestTbl.setDeleteFl(false);
		kiKidderQuestTbl.setDgrmImgInfoTbls(
				dgrmService.saveAllDgrm(kidderQuestModel.getDgrmImageInfoModels(), kiKidderQuestTbl));

		return kiKidderQuestRepo.save(kiKidderQuestTbl);

	}

	public Set<KiKidderQuestModel> getQuestionByQuizId(long quizId) throws Exception {

		List<KiKidderQuestTbl> kidderQuests = kiKidderQuestRepo.getQuestionByQuizId(quizId);
		Set<KiKidderQuestModel> kidderQuestModels = new HashSet<>();
		Set<DgrmImageInfoModel> dgrmModels = new HashSet<>();
		DgrmImageInfoModel dgrmModel = new DgrmImageInfoModel();

		for (KiKidderQuestTbl kikidderQ : kidderQuests) {
			KiKidderQuestModel questModel = new KiKidderQuestModel();

			questModel.setDgrmImageInfoModels(dgrmService.getDgrmModels(kikidderQ.getDgrmImgInfoTbls()));
			questModel.setDeleteFl(kikidderQ.getDeleteFl());
			questModel.setError(false);
			questModel.setStatus("Success");
			questModel.setKi_kidder_quest_ans(kikidderQ.getkqAns());
			questModel.setKi_kidder_quest_id(kikidderQ.getkqId());
			questModel.setKi_kidder_quest_level(kikidderQ.getkqLvl());
			questModel.setKi_kidder_quest_marks(kikidderQ.getkqMarks());
			questModel.setKi_kidder_quest_name(kikidderQ.getkqName());
			questModel.setKi_kidder_quest_optionA(kikidderQ.getkqOptionA());
			questModel.setKi_kidder_quest_optionB(kikidderQ.getkqOptionB());
			questModel.setKi_kidder_quest_optionC(kikidderQ.getkqOptionC());
			questModel.setKi_kidder_quest_optionD(kikidderQ.getkqOptionD());
			questModel.setKi_kidder_quest_sub(kikidderQ.getkqSub());
			questModel.setKi_kidder_quest_topic(kikidderQ.getkqTopic());
			questModel.setUniqueCode(kikidderQ.getUniqueCode());
			questModel.setTxtQuesInfoModel(txtQuestService.getTxtQuestModel(kikidderQ.getTxtQuesInfoTbl()));
//			Set<KiDgrmImgTbl> questDgrms = kikidderQ.getDgrmImgInfoTbls(); 
			
			KiUserModel userModel  = new KiUserModel();
			
			userModel.setDeleteFl(kikidderQ.getUserInfoTbl().getDeleteFl());
			userModel.setUser_email(kikidderQ.getUserInfoTbl().getUser_email());
			userModel.setUser_id(kikidderQ.getUserInfoTbl().getUser_id());
			userModel.setUser_name(kikidderQ.getUserInfoTbl().getUser_name());
			userModel.setUser_password(kikidderQ.getUserInfoTbl().getUser_password());
			userModel.setUser_phone_number(kikidderQ.getUserInfoTbl().getUser_phone_number());
			userModel.setUser_username(kikidderQ.getUserInfoTbl().getUser_username());
			
			questModel.setUserModel(userModel);
			
			kidderQuestModels.add(questModel);

		}

		return kidderQuestModels;

	}

	public Set<KiKidderQuestTbl> saveAllQuestByModel(Set<KiKidderQuestModel> questModels, long quizId) {

		Set<KiKidderQuestTbl> questTbls = new HashSet<>();
		Set<KiKidderQuestTbl> questionTbls = new HashSet<>();
		List<KiKidderQuestTbl> savedQuestTbls = new ArrayList<>();

		Boolean isEdit  = false;
		
		for (KiKidderQuestModel model : questModels) {
			KiKidderQuestTbl kiKidderQuestTbl = new KiKidderQuestTbl();
			if (model.getUniqueCode() != null) {
				isEdit = true;
				kiKidderQuestTbl = kiKidderQuestRepo.getByUniqueCode(model.getUniqueCode());
			} else {
				kiKidderQuestTbl.generateId();
				kiKidderQuestTbl
						.setUniqueCode(GenerateUniqueCode.Generate(kiKidderQuestTbl.getkqId(), "Ki_kidder_quest"));
				
			}

			kiKidderQuestTbl.setUserInfoTbl(userService.saveByModel(model.getUserModel()));
			kiKidderQuestTbl.setQuiz_id(quizId);
			kiKidderQuestTbl.setkqAns(model.getKi_kidder_quest_ans());
			kiKidderQuestTbl.setkqLvl(model.getKi_kidder_quest_level());
			kiKidderQuestTbl.setkqMarks(model.getKi_kidder_quest_marks());
			kiKidderQuestTbl.setkqName(model.getKi_kidder_quest_name());
			kiKidderQuestTbl.setkqOptionA(model.getKi_kidder_quest_optionA());
			kiKidderQuestTbl.setkqOptionB(model.getKi_kidder_quest_optionB());
			kiKidderQuestTbl.setkqSub(model.getKi_kidder_quest_sub());
			kiKidderQuestTbl.setkqTopic(model.getKi_kidder_quest_topic());
			kiKidderQuestTbl.setkqOptionC(model.getKi_kidder_quest_optionC());
			kiKidderQuestTbl.setkqOptionD(model.getKi_kidder_quest_optionD());
			
			
			if(model.getTxtQuesInfoModel() != null)
			{
				kiKidderQuestTbl
				.setTxtQuesInfoTbl(txtQuestService.saveTxtQuestByModel(model.getTxtQuesInfoModel()));
			}
			
			
		
			kiKidderQuestTbl.setDeleteFl(model.getDeleteFl());
			if(model.getDgrmImageInfoModels() != null && model.getDgrmImageInfoModels().size() != 0)
			{
				kiKidderQuestTbl.setDgrmImgInfoTbls(
						dgrmService.saveAllDgrms(model.getDgrmImageInfoModels(), kiKidderQuestTbl,isEdit));
			}else {
				kiKidderQuestTbl.setDgrmImgInfoTbls(null);
			}
		
			if(model.getDeleteFl())
			{
				kiKidderQuestRepo.delete(kiKidderQuestTbl);
			}else {
				savedQuestTbls.add(kiKidderQuestRepo.save(kiKidderQuestTbl));
			}
			

			
		}
		

		for(KiKidderQuestTbl tbl : savedQuestTbls)
		{
			questionTbls.add(tbl);
		}

		return questionTbls;
		
	}

}

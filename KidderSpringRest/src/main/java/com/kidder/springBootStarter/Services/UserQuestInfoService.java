package com.kidder.springBootStarter.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

@Service
public class UserQuestInfoService {

	@Autowired
	UserQuestInfoRepository userQuestInfoRepository;
	@Autowired
	UserQuestInfoTbl userQuestInfoTbl;
	@Autowired
	ImageInfoService imageInfoService;
	public List<UserQuestInfoTbl> batchQuestionInsert(List<UserQuestionModel> userQuestionModel){
		for(int i=0; i<userQuestionModel.size();i++) {
			if(userQuestionModel.get(i).getUser_quest_img_model() !=null  && !(userQuestionModel.get(i).getUser_quest_img_model().getUser_quest_img_base64_url() == null ||userQuestionModel.get(i).getUser_quest_img_model().getUser_quest_img_base64_url().isEmpty())) {
				userQuestionModel.get(i).setUser_quest_img_id((imageInfoService.insert(userQuestionModel.get(i).getUser_quest_img_model())).getImg_id());	
			}
			if(userQuestionModel.get(i).getUser_questdgrm_model() !=null && !(userQuestionModel.get(i).getUser_questdgrm_model().getUser_quest_img_base64_url()== null || userQuestionModel.get(i).getUser_questdgrm_model().getUser_quest_img_base64_url().isEmpty())) {
				userQuestionModel.get(i).setUser_quest_dgrm_id((imageInfoService.insert(userQuestionModel.get(i).getUser_questdgrm_model())).getImg_id());
			}
}
		
		 userQuestInfoRepository.saveAll(SetParams(userQuestionModel));
		return null;
//		List<UserQuestionModel> models = new ArrayList<UserQuestionModel>();
		
//		for(UserQuestInfoTbl tbl : userInfoQuesTbls)
//		{
//			UserQuestionModel userQuesModel = new UserQuestionModel();
//			if(tbl.getUser_quest_ans() != null)
//			{
//				userQuesModel.setUser_quest_ans(model.getUser_quest_ans());
//			}
//			if(tbl.getUser_quest_creator() != null)
//			{
//				userQuesModel.setUser_quest_creator(model.getUser_quest_creator());
//			}
//			if(tbl.getUser_quest_dgrm_id() != 0L)
//			{
//				userQuesModel.setUser_quest_dgrm_id(model.getUser_quest_dgrm_id());
//			}
//			if(tbl.getUser_quest_img_id() != 0L)
//			{
//				userQuesModel.setUser_quest_img_id(model.getUser_quest_img_id());
//			}
//			if(model.getUser_quest_img_model() != null)
//			{
//				
//			}
//			
//		}
//		
		
	}
	public List<UserQuestInfoTbl> SetParams(List<UserQuestionModel> userQuestionModel) {
		List<UserQuestInfoTbl> uqitList = new ArrayList<UserQuestInfoTbl>();
		for(UserQuestionModel uqm:userQuestionModel) {
			userQuestInfoTbl = new UserQuestInfoTbl();
			SetParams(uqm,userQuestInfoTbl);
			uqitList.add(userQuestInfoTbl);
		}
		return uqitList;
	}
	public void SetParams(UserQuestionModel uqm, UserQuestInfoTbl userQuestInfoTbl) {
		userQuestInfoTbl.setUser_quest_id(uqm.getUser_quest_id());
		userQuestInfoTbl.setUser_id(uqm.getUser_id());
		userQuestInfoTbl.setQuiz_id(uqm.getQuiz_id());
		userQuestInfoTbl.setUser_quest_txt_id(uqm.getUser_quest_txt_id());
		userQuestInfoTbl.setUser_quest_dgrm_id(uqm.getUser_quest_dgrm_id());
		userQuestInfoTbl.setUser_quest_img_id(uqm.getUser_quest_img_id());
		userQuestInfoTbl.setUser_quest_name(uqm.getUser_quest_name());
		userQuestInfoTbl.setUser_quest_creator(uqm.getUser_quest_creator());
		userQuestInfoTbl.setUser_quest_ans(uqm.getUser_quest_ans());
		userQuestInfoTbl.setUser_quest_marks(uqm.getUser_quest_marks());
		userQuestInfoTbl.setUser_quest_optionA(uqm.getUser_quest_optionA());
		userQuestInfoTbl.setUser_quest_optionB(uqm.getUser_quest_optionB());
		userQuestInfoTbl.setUser_quest_optionC(uqm.getUser_quest_optionC());
		userQuestInfoTbl.setUser_quest_optionD(uqm.getUser_quest_optionD());
	}
}

package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.KiGroupModel;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.UserQuestImgModel;
import com.kidder.springBootStarter.Model.KiUserQuestionModel;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;
import com.kidder.springBootStarter.Repo.QuizeInfoRepository;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

@Service
public class QuesService {

	@Autowired
	ImageService imageService;
	
	@Autowired
	QuizeInfoRepository quizeRepo;

	@Autowired 
	UserQuestInfoRepository userquesRepo;

	
	public KiUserQuestTbl saveUserQues(KiUserQuestTbl userQuesInfoTbl)
	{
		return userquesRepo.save(userQuesInfoTbl);
	}
	
	
	
	public KiUserQuestTbl saveUserQuestByModel(KiUserQuestionModel model,long quiz_id,KiUserTbl userTbl) throws Exception
	{
		KiUserQuestTbl userQuesInfoTbl = new KiUserQuestTbl();

		if(model.getUniqueCode() == null)
		{
			userQuesInfoTbl.generateId();
			userQuesInfoTbl.setUniqueCode(GenerateUniqueCode.Generate(userQuesInfoTbl.getUser_quest_id(), "uqt"));
			
		}else {
			userQuesInfoTbl.setUser_quest_id(model.getUser_quest_id());
			userQuesInfoTbl.setUniqueCode(model.getUniqueCode());
		}
			userQuesInfoTbl.setDeleteFl(false);
			userQuesInfoTbl.setQuiz_id(quiz_id);
			userQuesInfoTbl.setUser_quest_ans(model.getUser_quest_ans());
			userQuesInfoTbl.setUser_quest_marks(model.getUser_quest_marks());
			userQuesInfoTbl.setUser_quest_name(model.getUser_quest_name());
			userQuesInfoTbl.setUser_quest_optionA(model.getUser_quest_optionA());
			userQuesInfoTbl.setUser_quest_optionB(model.getUser_quest_optionB());
			userQuesInfoTbl.setUser_quest_optionC(model.getUser_quest_optionC());
			userQuesInfoTbl.setUser_quest_optionD(model.getUser_quest_optionD());
			userQuesInfoTbl.setUserInfoTbl(userTbl);
			userQuesInfoTbl.setTxtQuesInfoTbl(null);
			Set<KiImgTbl> imgTbls = new HashSet<>();

			Set<ImageInfoModel> imgQuests = new HashSet<>();
			
			for(ImageInfoModel imgModel : model.getImgInfoTbls())
			{
				imgQuests.add(imgModel);

			}

			try {
				userQuesInfoTbl.setImgInfoTbl(imageService.saveAllQuestImages(imgQuests,userQuesInfoTbl.getUser_quest_id()));

			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Unable to save images");
			}
			
			
			
			try {
				return userquesRepo.save(userQuesInfoTbl);

			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Unable to save questions");
			}
			
	}
	
}

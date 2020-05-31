package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.GenerateUniqueCode;
//import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizDetailModel;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.KiUserQuestionModel;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;
import com.kidder.springBootStarter.Repo.QuizeInfoRepository;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

@Service
public class QuizeInfoService {
@Autowired
QuizeInfoRepository quizeRepo;
@Autowired
ImageService imageService;

@Autowired
QuesService quesService;




	public KiQuizModel saveUserQuiz(List<KiUserQuestionModel> userQuesModels,KiQuizModel quizModel) throws Exception
	{

		QuizDetailModel quizDetail = new QuizDetailModel();
		
		Set<KiUserQuestTbl> questTbls = new HashSet<>();
		KiQuizeTbl quizTbl = new KiQuizeTbl();

		if(quizModel.getUniqueCode() == null)
		{
			quizTbl.generateId();
			quizTbl.setUniqueCode(GenerateUniqueCode.Generate(quizTbl.getQuiz_id(), "kqt"));
		}else {
			quizTbl.setQuiz_id(quizModel.getQuiz_id());
			quizTbl.setUniqueCode(quizModel.getUniqueCode());
		}
			quizTbl.setDeleteFl(false);
			if (quizModel.getQuiz_created_date() == null) 
			{
				long millis=System.currentTimeMillis();  
				quizTbl.setQuiz_created_date(new Timestamp(millis));
			}else {
				quizTbl.setQuiz_created_date(quizModel.getQuiz_created_date());
	
			}
			
			quizTbl.setQuiz_duration(quizModel.getQuiz_duration());
			quizTbl.setQuiz_marks(quizModel.getQuiz_marks());
			quizTbl.setQuiz_name(quizModel.getQuiz_name());
			quizTbl.setQuiz_num_of_ques(userQuesModels.size());
			quizTbl.setQuiz_published_date(quizModel.getQuiz_published_date());
			quizTbl.setQuiz_status(quizModel.getQuiz_status());
			KiUserTbl userTbl = new KiUserTbl();
			userTbl.setUser_email(quizModel.getUserModel().getUser_email());
			userTbl.setUser_id(quizModel.getUserModel().getUser_id());
			userTbl.setUser_name(quizModel.getUserModel().getUser_name());
			userTbl.setUser_password(quizModel.getUserModel().getUser_password());
			userTbl.setUser_phone_number(quizModel.getUserModel().getUser_phone_number());
			userTbl.setUniqueCode(quizModel.getUniqueCode());
			userTbl.setDeleteFl(false);
			quizTbl.setUserInfoTbl(userTbl);
			KiGroupTbl grpTbl = new KiGroupTbl();
			
			grpTbl.setGrp_admin(quizModel.getGrpModel().getGrp_admin());
			grpTbl.setGrp_desc(quizModel.getGrpModel().getGrp_desc());
			grpTbl.setGrp_name(quizModel.getGrpModel().getGrp_name());
			grpTbl.setGrp_id(quizModel.getGrpModel().getGrp_id());
			grpTbl.setUniqueCode(quizModel.getUniqueCode());
			grpTbl.setDeleteFl(false);
			quizTbl.setGrpInfoTbl(grpTbl);
			
		
		
		if(userQuesModels.size() > 0)
		{
			for(KiUserQuestionModel model : userQuesModels)
			{
				try {
					questTbls.add(quesService.saveUserQuestByModel(model,quizModel.getQuiz_id(),userTbl));

				}catch (Exception e) {
					// TODO: handle exception
					throw new Exception("Unable to save questions");
				}
			}
		}
	
		quizTbl.setUserQuestTbls(questTbls);
		KiQuizModel quizeModel = new KiQuizModel();

		try {
			KiQuizeTbl quizeTable = quizeRepo.save(quizTbl);
			quizModel.setError(null);
			quizModel.setStatus("Success");
			quizModel.setDeleteFl(quizeTable.getDeleteFl());
			quizModel.setQuiz_created_date(quizeTable.getQuiz_created_date());
			quizModel.setQuiz_duration(quizeTable.getQuiz_duration());
			quizModel.setQuiz_exam(null);
			quizModel.setQuiz_id(quizeTable.getQuiz_id());
			quizModel.setQuiz_marks(quizeTable.getQuiz_marks());
			quizModel.setQuiz_name(quizeTable.getQuiz_name());
			quizModel.setQuiz_num_of_ques(quizeTable.getQuiz_num_of_ques());
			quizModel.setQuiz_published_date(quizeTable.getQuiz_published_date());
			quizModel.setQuiz_sub(quizeTable.getQuizSub());
			quizModel.setQuiz_topic(quizeTable.getQuizTopic());
			
		}catch(Exception e)
		{
			quizModel.setError(e.getMessage());
			quizModel.setStatus("Failed");
		}
		
		
		return quizModel;
	
	}

}

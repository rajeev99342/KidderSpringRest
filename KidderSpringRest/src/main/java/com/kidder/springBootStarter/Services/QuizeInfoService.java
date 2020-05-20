package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizDetailModel;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.KiUserQuestionModel;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;
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




	public QuizDetailModel saveUserQuiz(List<KiUserQuestionModel> userQuesModels,KiQuizModel quizModel)
	{

		QuizDetailModel quizDetail = new QuizDetailModel();
		
		if(quizModel != null)
		{
			if(quizModel.getGrpModel() != null)
			{
				KiQuizeTbl quizTbl = new KiQuizeTbl();
				
				KiGroupTbl grpTbl = new KiGroupTbl();
				
				grpTbl.setGrp_admin(quizModel.getGrpModel().getGrp_admin());
				grpTbl.setGrp_desc(quizModel.getGrpModel().getGrp_desc());
				grpTbl.setGrp_name(quizModel.getGrpModel().getGrp_name());
				grpTbl.setGrp_id(quizModel.getGrpModel().getGrp_id());
				
				KiUserTbl userTbl = new KiUserTbl();
				userTbl.setUser_email(quizModel.getUserModel().getUser_email());
				userTbl.setUser_id(quizModel.getUserModel().getUser_id());
				userTbl.setUser_name(quizModel.getUserModel().getUser_name());
				userTbl.setUser_password(quizModel.getUserModel().getUser_password());
				userTbl.setUser_phone_number(quizModel.getUserModel().getUser_phone_number());
				
				
				quizTbl.setUserInfoTbl(userTbl);
				quizTbl.setGrpInfoTbl(grpTbl);
				
				if (quizModel.getQuiz_created_date() == null) 
				{
					long millis=System.currentTimeMillis();  
					quizTbl.setQuiz_created_date(new Timestamp(millis));
				}
				
				quizTbl.setQuiz_duration(quizModel.getQuiz_duration());
				quizTbl.setQuiz_marks(quizModel.getQuiz_marks());
				quizTbl.setQuiz_name(quizModel.getQuiz_name());
				quizTbl.setQuiz_num_of_ques(userQuesModels.size());
				quizTbl.setQuiz_published_date(quizModel.getQuiz_published_date());
				
				if(quizModel.getQuiz_id() != 0L)
				{
					quizTbl.setQuiz_id(quizModel.getQuiz_id());
				}
				
				
				KiQuizeTbl qTbl =  quizeRepo.save(quizTbl);
				
				List<KiUserQuestionModel> questions = new ArrayList<>();
				
				if(userQuesModels.size() > 0)
				{
					for(KiUserQuestionModel model : userQuesModels)
					{
						
			
						
						KiImgTbl mTbl = imageService.saveQuesImage(model.getImageInfoModel());
						
						UserQuestInfoTbl userQuesInfoTbl = new UserQuestInfoTbl();
						
						userQuesInfoTbl.setQuizInfoTbl(qTbl);
						
						userQuesInfoTbl.setUserInfoTbl(userTbl);
						
						userQuesInfoTbl.setImgInfoTbl(mTbl);
						
//						userQuesInfoTbl.setDgrmImgInfoTbl(null);
						
//						userQuesInfoTbl.setTxtQuesInfoTbl(null);
						
						userQuesInfoTbl.setUser_quest_ans(model.getUser_quest_ans());
						
						userQuesInfoTbl.setUser_quest_marks(model.getUser_quest_marks());
						
						userQuesInfoTbl.setUser_quest_name("random");
						
						userQuesInfoTbl.setUser_quest_optionA(model.getUser_quest_optionA());
						
						userQuesInfoTbl.setUser_quest_optionB(model.getUser_quest_optionB());
						
						userQuesInfoTbl.setUser_quest_optionC(model.getUser_quest_optionC());
						
						userQuesInfoTbl.setUser_quest_optionD(model.getUser_quest_optionD());
						
						if(model.getUser_quest_id() != 0L)
						{
							userQuesInfoTbl.setUser_quest_id(model.getUser_quest_id());
						}
						
					    UserQuestInfoTbl userQTbl =	quesService.saveUserQues(userQuesInfoTbl);
					    
					    ImageInfoModel imageModel = ConvertedHelper.getImageModel(mTbl);
					    
					    KiUserQuestionModel qmodel = ConvertedHelper.getUserQuestionModel(userQTbl);
					    
					 
					    questions.add(qmodel);
						
						
						
					}
				}
				
				quizDetail.setQuestions(questions);
				KiQuizModel quizeModel = new KiQuizModel();
				quizeModel.setQuiz_id(qTbl.getQuiz_id());
				
				quizDetail.setError(null);
				quizDetail.setStatus("Success");
				quizDetail.setQuizModel(quizeModel);
				
			}
		}
			
		
		return quizDetail;
	
	}

}

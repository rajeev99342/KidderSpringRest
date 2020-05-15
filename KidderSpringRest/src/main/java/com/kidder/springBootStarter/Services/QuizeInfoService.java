package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizDetailModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
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




	public QuizDetailModel saveUserQuiz(List<UserQuestionModel> userQuesModels,QuizModel quizModel)
	{

		QuizDetailModel quizDetail = new QuizDetailModel();
		
		if(quizModel != null)
		{
			if(quizModel.getGrpModel() != null)
			{
				QuizeInfoTbl quizTbl = new QuizeInfoTbl();
				
				GroupInfoTbl grpTbl = new GroupInfoTbl();
				
				grpTbl.setGrp_admin(quizModel.getGrpModel().getGrp_admin());
				grpTbl.setGrp_desc(quizModel.getGrpModel().getGrp_desc());
				grpTbl.setGrp_name(quizModel.getGrpModel().getGrp_name());
				grpTbl.setGrp_unique_code(quizModel.getGrpModel().getGrp_unique_code());
				grpTbl.setGrp_id(quizModel.getGrpModel().getGrp_id());
				
				UserInfoTbl userTbl = new UserInfoTbl();
				userTbl.setUser_email(quizModel.getUserModel().getUser_email());
				userTbl.setUser_id(quizModel.getUserModel().getUser_id());
				userTbl.setUser_name(quizModel.getUserModel().getUser_name());
				userTbl.setUser_password(quizModel.getUserModel().getUser_password());
				userTbl.setUser_phone_number(quizModel.getUserModel().getUser_phone_number());
				userTbl.setUser_unique_code(quizModel.getUserModel().getUser_unique_code());
				
				
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
				
				
				QuizeInfoTbl qTbl =  quizeRepo.save(quizTbl);
				
				List<UserQuestionModel> questions = new ArrayList<>();
				
				if(userQuesModels.size() > 0)
				{
					for(UserQuestionModel model : userQuesModels)
					{
						
			
						
						ImageInfoTbl mTbl = imageService.saveQuesImage(model.getImageInfoModel());
						
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
					    
					    UserQuestionModel qmodel = ConvertedHelper.getUserQuestionModel(userQTbl);
					    
					 
					    questions.add(qmodel);
						
						
						
					}
				}
				
				quizDetail.setQuestions(questions);
				QuizModel quizeModel = new QuizModel();
				quizeModel.setQuiz_id(qTbl.getQuiz_id());
				
				
				quizDetail.setQuizModel(quizeModel);
				
			}
		}
			
		
		return quizDetail;
	
	}

}

package com.kidder.springBootStarter.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;
import com.kidder.springBootStarter.Repo.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;
	
	public void getQuestionByQuizId(long quiz_id)
	{
	  List<UserQuestInfoTbl> questions = questionRepo.getQuestionByQuizId(quiz_id);
	  
	  List<UserQuestionModel> questionModels = new ArrayList<UserQuestionModel>();
	  
	  for(UserQuestInfoTbl tbl : questions)
	  {
		  UserQuestionModel model = new UserQuestionModel();
		  
		  model.setDgrmImageInfoModel(null);
		  
		  QuizModel quizModel = new QuizModel();
		  
		  quizModel.setGrpModel(null);
		  quizModel.setQuiz_created_date(tbl.getQuizInfoTbl().getQuiz_created_date());
		  
		  ImageInfoModel imageInfoModel = new ImageInfoModel();
		  
		  if(tbl.getImgInfoTbl() != null)
		  {
			  imageInfoModel.setImg_base64(img_base64);
		  }
		  
		  model.setQuizModel(quizModel);
		  
	  }
	  
	}
	
}

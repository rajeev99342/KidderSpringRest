package com.kidder.springBootStarter.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Repo.TestRoomRepository;

@Service
public class TestRoomService {

	@Autowired
	TestRoomRepository testRoomRepo;
	
	public List<QuizModel> getTestRoomByGroupId(long grp_id)
	{
	
			List<QuizeInfoTbl> quizInfoTbls =  testRoomRepo.getTestRoomByGroupId(grp_id);
			
			List<QuizModel> quizModels = new ArrayList<QuizModel>();
			
			for(QuizeInfoTbl tbl : quizInfoTbls)
			{
				QuizModel model = new QuizModel();
				
				model.setGrpModel(null);
				model.setQuiz_created_date(tbl.getQuiz_created_date());
				model.setQuiz_duration(model.getQuiz_duration());
				model.setQuiz_id(tbl.getQuiz_id());
				model.setQuiz_marks(model.getQuiz_marks());
				model.setQuiz_name(tbl.getQuiz_name());
				model.setQuiz_num_of_ques(tbl.getQuiz_num_of_ques());
				model.setQuiz_published_date(tbl.getQuiz_published_date());
				UserModel userModel = new UserModel();
				model.setQuiz_status(tbl.getQuiz_status());
				userModel.setError(null);
				userModel.setStatus("Success");
				userModel.setUser_email(tbl.getUserInfoTbl().getUser_email());
				userModel.setUser_id(tbl.getUserInfoTbl().getUser_id());
				userModel.setUser_name(tbl.getUserInfoTbl().getUser_name());
				userModel.setUser_phone_number(tbl.getUserInfoTbl().getUser_phone_number());
				userModel.setUser_username(tbl.getUserInfoTbl().getUser_username());
				
				model.setUserModel(userModel);
				
				quizModels.add(model);
				
			}
			return quizModels;
			
	}
	
}

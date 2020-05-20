package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
import com.kidder.springBootStarter.Repo.TestRoomRepository;

@Service
public class TestRoomService {

	@Autowired
	TestRoomRepository testRoomRepo;
	
	public List<KiQuizModel> getTestRoomByGroupId(long grp_id)
	{
	
			List<KiQuizeTbl> quizInfoTbls =  testRoomRepo.getTestRoomByGroupId(grp_id);
			
			List<KiQuizModel> quizModels = new ArrayList<KiQuizModel>();
			
			for(KiQuizeTbl tbl : quizInfoTbls)
			{
				KiQuizModel model = new KiQuizModel();
				
				model.setGrpModel(null);
				model.setQuiz_created_date(tbl.getQuiz_created_date());
				model.setQuiz_duration(tbl.getQuiz_duration());
				model.setQuiz_id(tbl.getQuiz_id());
				model.setQuiz_marks(tbl.getQuiz_marks());
				model.setQuiz_name(tbl.getQuiz_name());
				model.setQuiz_num_of_ques(tbl.getQuiz_num_of_ques());
				model.setQuiz_published_date(tbl.getQuiz_published_date());
				KiUserModel userModel = new KiUserModel();
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
	
	
	public KiQuizModel startTest(KiQuizModel quizModel,String mode)
	{
		
		KiQuizeTbl quizTbl= null;
		
		if(quizModel != null && quizModel.getUserModel() != null)
		{
			
			try {
				KiQuizeTbl tbl = testRoomRepo.getQuizByQuizId(quizModel.getQuiz_id());
				
				if(mode.equals("start")) {
					tbl.setQuiz_status(1);
				}else if(mode.equals("end")) {
					tbl.setQuiz_status(2);
				}
				
				long millis=System.currentTimeMillis();  
				
				tbl.setQuiz_published_date(new Timestamp(millis));
//				quizTbl.setQuiz_created_date(new Timestamp(millis));
				
				
				quizTbl = testRoomRepo.save(tbl);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("error while start test"+e.getMessage());
			}
			
			quizModel = null;
			quizModel =  ConvertedHelper.getQuizModel(quizTbl);
			quizModel.setError(null);
			quizModel.setStatus("Success");
			
		}
		
		return quizModel;
	}
	
}

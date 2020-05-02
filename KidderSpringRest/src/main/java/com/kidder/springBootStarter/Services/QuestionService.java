package com.kidder.springBootStarter.Services;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;
import com.kidder.springBootStarter.Repo.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;
	
	public List<UserQuestionModel> getQuestionByQuizId(long quiz_id) throws Exception
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

			  File newFile = new File(tbl.getImgInfoTbl().getImg_path());
//			  byte[] fileContent = FileUtils.readFileToByteArray(image);
//			  String encodedString = Base64.getEncoder().encodeToString(fileContent);
			  imageInfoModel.setImg_base64(QuestionService.encodeFileToBase64Binary(newFile));
			  imageInfoModel.setImg_desc(tbl.getImgInfoTbl().getImg_desc());
			  imageInfoModel.setImg_id(tbl.getImgInfoTbl().getImg_id());
			  imageInfoModel.setImg_name(tbl.getImgInfoTbl().getImg_name());
			  imageInfoModel.setImg_path(tbl.getImgInfoTbl().getImg_path());
			  
		  }
		  UserModel userModel = new UserModel();
		  if(tbl.getUserInfoTbl() != null)
		  {
			  
//			  userModel.setError(null);
//			  userModel.setStatus("Success");
//			  userModel.setUser_email(tbl.getUserInfoTbl().getUser_email());
//			  userModel.setUser_id(tbl.getUserInfoTbl().getUser_id());
//			  userModel.setUser_name(tbl.getUserInfoTbl().getUser_name());
//			  userModel.setUser_password(tbl.getUserInfoTbl().getUser_password());
//			  userModel.setUser_username(tbl.getUserInfoTbl().getUser_username());
			  
			  model.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
		  }
		  
		 
		  model.setImageInfoModel(imageInfoModel);
		  if(tbl.getQuizInfoTbl() != null)
		  {
			  
			  model.setQuizModel(ConvertedHelper.getQuizModel(tbl.getQuizInfoTbl()));
		  }
		 
		  model.setUser_quest_ans(tbl.getUser_quest_ans());
		  model.setUser_quest_id(tbl.getUser_quest_id());
		  model.setUser_quest_marks(tbl.getUser_quest_marks());
		  model.setUser_quest_name(tbl.getUser_quest_name());
		  model.setUser_quest_optionA(tbl.getUser_quest_optionA());
		  model.setUser_quest_optionB(tbl.getUser_quest_optionB());
		  model.setUser_quest_optionC(tbl.getUser_quest_optionC());
		  model.setUser_quest_optionD(tbl.getUser_quest_optionD());
		  questionModels.add(model);
		  
	  }
	  
	  return questionModels;
	  
	}
	 private static String encodeFileToBase64Binary(File file) throws Exception{
		//encode image to Base64 String
//			File f = new File("H:/encode/sourceImage.png");		//change path of image according to you
			FileInputStream fis = new FileInputStream(file);
			byte byteArray[] = new byte[(int)file.length()];
			fis.read(byteArray);
			String imageString = "data:image/png;base64,"+ Base64.encodeBase64String(byteArray);
			System.out.println(imageString);
			return imageString;
     }
	 

	
}

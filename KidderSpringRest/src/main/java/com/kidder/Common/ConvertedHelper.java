package com.kidder.Common;

import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Model.UserQuestImgModel;
import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.GroupParticipantTbl;
import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;

public class ConvertedHelper {
	
	
	 public static QuizModel getQuizModel(QuizeInfoTbl tbl)
	 {
		 QuizModel quizModel = new QuizModel();
		 
		 quizModel.setGrpModel(ConvertedHelper.getGroupModel(tbl.getGrpInfoTbl()));
		 quizModel.setQuiz_created_date(tbl.getQuiz_created_date());
		 quizModel.setQuiz_duration(tbl.getQuiz_duration());
		 quizModel.setQuiz_id(tbl.getQuiz_id());
		 quizModel.setQuiz_marks(tbl.getQuiz_marks());
		 quizModel.setQuiz_name(tbl.getQuiz_name());
		 quizModel.setQuiz_num_of_ques(tbl.getQuiz_num_of_ques());
		 quizModel.setQuiz_published_date(tbl.getQuiz_published_date());
		 quizModel.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
		 return quizModel;
		 
	 }
	 
	 public static GroupModel getGroupModel(GroupInfoTbl tbl)
	 {
		 GroupModel model = new GroupModel();
		 
		 model.setError(null);
		 model.setGrp_admin(tbl.getGrp_admin());
		 model.setGrp_desc(tbl.getGrp_desc());
		 model.setGrp_id(tbl.getGrp_id());
		 model.setGrp_unique_code(tbl.getGrp_unique_code());
		 return model;
	 }
	 
	 public static UserModel getUserModel(UserInfoTbl tbl)
	 {
		 UserModel userModel = new UserModel();
		 userModel.setError(null);
		 userModel.setUser_email(tbl.getUser_email());
		 userModel.setUser_id(tbl.getUser_id());
		 userModel.setUser_name(tbl.getUser_name());
		 userModel.setUser_password(tbl.getUser_password());
		 userModel.setUser_phone_number(tbl.getUser_phone_number());
		 userModel.setUser_unique_code(tbl.getUser_unique_code());
		 userModel.setUser_username(tbl.getUser_username());
		 return userModel;
	 }
	 
	 public static ImageInfoModel getImageModel(ImageInfoTbl tbl)
	 {
		 ImageInfoModel model = new ImageInfoModel();
		 
		 model.setImg_base64(tbl.getImg_base64());
		 model.setImg_desc(tbl.getImg_desc());
		 model.setImg_name(tbl.getImg_name());
		 model.setImg_path(tbl.getImg_path());
		 model.setImg_id(tbl.getImg_id());
		 return model;
	 }
	 
	 public static UserQuestionModel getUserQuestionModel(UserQuestInfoTbl tbl) 
	 {
		 UserQuestionModel questionModel = new UserQuestionModel();
		 questionModel.setImageInfoModel(ConvertedHelper.getImageModel(tbl.getImgInfoTbl()));
		 questionModel.setQuizModel(ConvertedHelper.getQuizModel(tbl.getQuizInfoTbl()));
		 questionModel.setUser_quest_ans(tbl.getUser_quest_ans());
		 questionModel.setUser_quest_id(tbl.getUser_quest_id());
		 questionModel.setUser_quest_marks(tbl.getUser_quest_marks());
		 questionModel.setUser_quest_name(tbl.getUser_quest_name());
		 questionModel.setUser_quest_optionA(tbl.getUser_quest_optionA());
		 questionModel.setUser_quest_optionB(tbl.getUser_quest_optionB());
		 questionModel.setUser_quest_optionC(tbl.getUser_quest_optionC());
		 questionModel.setUser_quest_optionD(tbl.getUser_quest_optionD());
		 
		 questionModel.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
		 
		 
		 return questionModel;
		 
	 }
	 
	 
	 public static UserInfoTbl getUserTbl(UserModel model)
	 {
		 UserInfoTbl tbl = new UserInfoTbl();
		 
		 tbl.setUser_email(model.getUser_email());
		 tbl.setUser_id(model.getUser_id());
		 tbl.setUser_name(model.getUser_name());
		 tbl.setUser_password(model.getUser_password());
		 tbl.setUser_phone_number(model.getUser_phone_number());
		 tbl.setUser_unique_code(model.getUser_unique_code());
		 tbl.setUser_username(model.getUser_username());
		 
		 return tbl;
	 }
	 
	 public static GroupInfoTbl getGroupTbl(GroupModel model)
	 {
		 GroupInfoTbl tbl = new GroupInfoTbl();
		 
		 tbl.setGrp_admin(model.getGrp_admin());
		 tbl.setGrp_desc(model.getGrp_desc());
		 tbl.setGrp_id(model.getGrp_id());
		 tbl.setGrp_unique_code(model.getGrp_unique_code());
		 tbl.setGrp_name(model.getGrp_name());
		 
		 return tbl;
	 }
	 
	 public static GroupParticipantModel getGroupParticipantModel(GroupParticipantTbl tbl)
	 {
		 GroupParticipantModel model = new GroupParticipantModel();
		 
		 model.setGroupModel(ConvertedHelper.getGroupModel(tbl.getGroupInfoTbl()));
		 model.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTb()));
		 model.setGrp_part_id(tbl.getGrp_part_id());
		 model.setIsAdmin(tbl.getIsAdmin());
		 return model;
	 }
	 
	 
}

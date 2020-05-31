//package com.kidder.Common;
//
//import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
//import com.kidder.springBootStarter.Model.KiGroupModel;
//import com.kidder.springBootStarter.Model.GroupParticipantModel;
//import com.kidder.springBootStarter.Model.ImageInfoModel;
//import com.kidder.springBootStarter.Model.KiKidderQuestModel;
//import com.kidder.springBootStarter.Model.KiQuizModel;
//import com.kidder.springBootStarter.Model.KiTxtQuesModel;
//import com.kidder.springBootStarter.Model.KiUserModel;
//import com.kidder.springBootStarter.Model.UserQuestImgModel;
//import com.kidder.springBootStarter.Model.KiUserQuestionModel;
//import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;
//import com.kidder.springBootStarter.Pojo.KiGroupTbl;
//import com.kidder.springBootStarter.Pojo.KiGroupParticipantTbl;
//import com.kidder.springBootStarter.Pojo.KiImgTbl;
//import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
//import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
//import com.kidder.springBootStarter.Pojo.KiTxtQuestTbl;
//import com.kidder.springBootStarter.Pojo.KiUserTbl;
//import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;
//
//public class ConvertedHelper {
//	
//	
//	public static KiKidderQuestTbl getKidderQuestTbl(KiKidderQuestModel model)
//	{
//		KiKidderQuestTbl tbl = new KiKidderQuestTbl();
//		
//			if(model.getKi_kidder_quest_id() != null)
//			{
//				tbl.setKi_kidder_quest_id(model.getKi_kidder_quest_id());
//			}
//			tbl.setKi_kidder_quest_ans(model.getKi_kidder_quest_ans());
//			tbl.setKi_kidder_quest_level(model.getKi_kidder_quest_level());
//			tbl.setKi_kidder_quest_marks(model.getKi_kidder_quest_marks());
//			tbl.setKi_kidder_quest_name(model.getKi_kidder_quest_name());
//			tbl.setKi_kidder_quest_optionA(model.getKi_kidder_quest_optionA());
//			tbl.setKi_kidder_quest_optionB(model.getKi_kidder_quest_optionB());
//			tbl.setKi_kidder_quest_sub(model.getKi_kidder_quest_sub());
//			tbl.setKi_kidder_quest_topic(model.getKi_kidder_quest_topic());
//			tbl.setKi_kidder_quest_optionC(model.getKi_kidder_quest_optionC());
//			tbl.setKi_kidder_quest_optionD(model.getKi_kidder_quest_optionD());
//			
//			if(model.getUserModel() != null )
//			{
//				tbl.setUserInfoTbl(ConvertedHelper.getUserTbl(model.getUserModel()));
//			}
//			if(model.getTxtQuesInfoModel() != null)
//			{
//				tbl.setTxtQuesInfoTbl(ConvertedHelper.getTxtQuestionTbl(model.getTxtQuesInfoModel()));
//			}
//			return tbl;
//
//	}
//	
//	
//	public static KiKidderQuestModel getKidderQuestModel(KiKidderQuestTbl tbl)
//	{
//		KiKidderQuestModel model = new KiKidderQuestModel();
//		
//			if(tbl.getKi_kidder_quest_id() != null)
//			{
//				model.setKi_kidder_quest_id(tbl.getKi_kidder_quest_id());
//			}
//			model.setKi_kidder_quest_ans(tbl.getKi_kidder_quest_ans());
//			model.setKi_kidder_quest_level(tbl.getKi_kidder_quest_level());
//			model.setKi_kidder_quest_marks(tbl.getKi_kidder_quest_marks());
//			model.setKi_kidder_quest_name(tbl.getKi_kidder_quest_name());
//			model.setKi_kidder_quest_optionA(tbl.getKi_kidder_quest_optionA());
//			model.setKi_kidder_quest_optionB(tbl.getKi_kidder_quest_optionB());
//			model.setKi_kidder_quest_sub(tbl.getKi_kidder_quest_sub());
//			model.setKi_kidder_quest_topic(tbl.getKi_kidder_quest_topic());
//			model.setKi_kidder_quest_optionC(tbl.getKi_kidder_quest_optionC());
//			model.setKi_kidder_quest_optionD(tbl.getKi_kidder_quest_optionD());
//			
//			if(tbl.getUserInfoTbl() != null )
//			{
//				model.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
//			}
//			if(tbl.getTxtQuesInfoTbl() != null)
//			{
//				model.setTxtQuesInfoModel(ConvertedHelper.getTxtQuestionModel(tbl.getTxtQuesInfoTbl()));
//			}
//			return model;
//
//	}
//	
//	
//	 public static KiQuizModel getQuizModel(KiQuizeTbl tbl)
//	 {
//		 KiQuizModel quizModel = new KiQuizModel();
//		 
//		 if(tbl.getGrpInfoTbl() != null)
//		 {
//			 quizModel.setGrpModel(ConvertedHelper.getGroupModel(tbl.getGrpInfoTbl()));
//
//		 }
//		 
//		 quizModel.setQuiz_status(tbl.getQuiz_status());
//		 quizModel.setQuiz_created_date(tbl.getQuiz_created_date());
//		 quizModel.setQuiz_duration(tbl.getQuiz_duration());
//		 quizModel.setQuiz_id(tbl.getQuiz_id());
//		 quizModel.setQuiz_marks(tbl.getQuiz_marks());
//		 quizModel.setQuiz_name(tbl.getQuiz_name());
//		 quizModel.setQuiz_num_of_ques(tbl.getQuiz_num_of_ques());
//		 quizModel.setQuiz_published_date(tbl.getQuiz_published_date());
//		 quizModel.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
//		 return quizModel;
//		 
//	 }
//	 
//	 public static KiGroupModel getGroupModel(KiGroupTbl tbl)
//	 {
//		 KiGroupModel model = new KiGroupModel();
//		 model.setGrp_name(tbl.getGrp_name());
//		 model.setError(null);
//		 model.setGrp_admin(tbl.getGrp_admin());
//		 model.setGrp_desc(tbl.getGrp_desc());
//		 model.setGrp_id(tbl.getGrp_id());
//		 return model;
//	 }
//	 
//	 public static KiUserModel getUserModel(KiUserTbl tbl)
//	 {
//		 KiUserModel userModel = new KiUserModel();
//		 userModel.setError(null);
//		 userModel.setUser_email(tbl.getUser_email());
//		 userModel.setUser_id(tbl.getUser_id());
//		 userModel.setUser_name(tbl.getUser_name());
//		 userModel.setUser_password(tbl.getUser_password());
//		 userModel.setUser_phone_number(tbl.getUser_phone_number());
//		 userModel.setUser_username(tbl.getUser_username());
//		 return userModel;
//	 }
//	 
//	 public static ImageInfoModel getImageModel(KiImgTbl tbl)
//	 {
//		 ImageInfoModel model = new ImageInfoModel();
//		 
//		 model.setImg_base64(tbl.getImg_base64());
//		 model.setImg_desc(tbl.getImg_desc());
//		 model.setImg_name(tbl.getImg_name());
//		 model.setImg_path(tbl.getImg_path());
//		 model.setImg_id(tbl.getImg_id());
//		 return model;
//	 }
//	 
//	 public static KiImgTbl getImageTbl( ImageInfoModel model)
//	 {
//		 KiImgTbl tbl = new KiImgTbl();
//		 
//		 tbl.setImg_base64(model.getImg_base64());
//		 tbl.setImg_desc(model.getImg_desc());
//		 tbl.setImg_name(model.getImg_name());
//		 tbl.setImg_path(model.getImg_path());
//		 tbl.setImg_id(model.getImg_id());
//		 return tbl;
//	 }
//	 
//	 
//	 public static KiUserQuestionModel getUserQuestionModel(KiUserQuestTbl tbl) 
//	 {
//		 KiUserQuestionModel questionModel = new KiUserQuestionModel();
//		 questionModel.setImageInfoModel(ConvertedHelper.getImageModel(tbl.getImgInfoTbl()));
//		 questionModel.setQuizModel(ConvertedHelper.getQuizModel(tbl.getQuizInfoTbl()));
//		 questionModel.setUser_quest_ans(tbl.getUser_quest_ans());
//		 questionModel.setUser_quest_id(tbl.getUser_quest_id());
//		 questionModel.setUser_quest_marks(tbl.getUser_quest_marks());
//		 questionModel.setUser_quest_name(tbl.getUser_quest_name());
//		 questionModel.setUser_quest_optionA(tbl.getUser_quest_optionA());
//		 questionModel.setUser_quest_optionB(tbl.getUser_quest_optionB());
//		 questionModel.setUser_quest_optionC(tbl.getUser_quest_optionC());
//		 questionModel.setUser_quest_optionD(tbl.getUser_quest_optionD());
//		 
//		 questionModel.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTbl()));
//		 
//		 
//		 return questionModel;
//		 
//	 }
//	 
//	 
//	 public static KiUserTbl getUserTbl(KiUserModel model)
//	 {
//		 KiUserTbl tbl = new KiUserTbl();
//		 
//		 tbl.setUser_email(model.getUser_email());
//		 tbl.setUser_id(model.getUser_id());
//		 tbl.setUser_name(model.getUser_name());
//		 tbl.setUser_password(model.getUser_password());
//		 tbl.setUser_phone_number(model.getUser_phone_number());
//		 tbl.setUser_username(model.getUser_username());
//		 
//		 return tbl;
//	 }
//	 
//	 public static KiGroupTbl getGroupTbl(KiGroupModel model)
//	 {
//		 KiGroupTbl tbl = new KiGroupTbl();
//		 
//		 tbl.setGrp_admin(model.getGrp_admin());
//		 tbl.setGrp_desc(model.getGrp_desc());
//		 tbl.setGrp_id(model.getGrp_id());
//		 tbl.setGrp_name(model.getGrp_name());
//		 
//		 return tbl;
//	 }
//	 
//	 public static GroupParticipantModel getGroupParticipantModel(KiGroupParticipantTbl tbl)
//	 {
//		 GroupParticipantModel model = new GroupParticipantModel();
//		 
//		 model.setGroupModel(ConvertedHelper.getGroupModel(tbl.getGroupInfoTbl()));
//		 model.setUserModel(ConvertedHelper.getUserModel(tbl.getUserInfoTb()));
//		 model.setGrp_part_id(tbl.getGrp_part_id());
//		 model.setIsAdmin(tbl.getIsAdmin());
//		 return model;
//	 }
//	 
//	 
//	 public static KiTxtQuestTbl getTxtQuestionTbl (KiTxtQuesModel model)
//	 {
//		 KiTxtQuestTbl tbl = new KiTxtQuestTbl();
//		 tbl.setQuesTxt(model.getQuesTxt());
//		 tbl.setTxt_ques_id(model.getTxt_ques_id());
//		 return tbl;
//	 }
//	 
//	 public static KiTxtQuesModel  getTxtQuestionModel (KiTxtQuestTbl tbl )
//	 {
//		 KiTxtQuesModel model = new KiTxtQuesModel();
//		 model.setQuesTxt(tbl.getQuesTxt());
//		 model.setTxt_ques_id(tbl.getTxt_ques_id());
//		 return model;
//	 }
//	 
//	 
//	 public static KiQuizeTbl getQuizTbl(KiQuizModel model)
//	 {
//		 KiQuizeTbl tbl = new KiQuizeTbl();
//		 
//		 if(model.getGrpModel() != null)
//		 {
//			 tbl.setGrpInfoTbl(ConvertedHelper.getGroupTbl(model.getGrpModel()));
//
//		 }
//		 
//		 
//		 tbl.setUserInfoTbl(ConvertedHelper.getUserTbl(model.getUserModel()));
//		 tbl.setQuiz_created_date(model.getQuiz_created_date());
//		 tbl.setQuiz_duration(model.getQuiz_duration());
//		 tbl.setQuiz_id(model.getQuiz_id());
//		 tbl.setQuiz_marks(model.getQuiz_marks());
//		 tbl.setQuiz_name(model.getQuiz_name());
//		 tbl.setQuiz_num_of_ques(model.getQuiz_num_of_ques());
//		 tbl.setQuiz_status(1);
//		 
//		 
//		 
//		 return tbl;
//		 
//	 }
//	 
//	 public static KiUserQuestTbl getQuestionTbl(KiUserQuestionModel model)
//	 {
//		 KiUserTbl userTbl = null;
//		 KiQuizeTbl quizTbl = null;
//		 KiImgTbl imgTbl = null;
//		 KiTxtQuestTbl txtTbl = null;
//		 if(model.getUserModel() != null)
//		 {
//			 userTbl = ConvertedHelper.getUserTbl(model.getUserModel());
//		 }
//		 if(model.getQuizModel() != null)
//		 {
//			 quizTbl = ConvertedHelper.getQuizTbl(model.getQuizModel());
//		 }
//		 
//		 KiUserQuestTbl tbl = new KiUserQuestTbl();
//		 tbl.setUserInfoTbl(userTbl);
//		 tbl.setQuizInfoTbl(quizTbl);
//		 if(model.getImageInfoModel() != null)
//		 {
//			imgTbl = ConvertedHelper.getImageTbl(model.getImageInfoModel());
//		 }
//		 tbl.setImgInfoTbl(imgTbl);
//		 if(model.getTxtQuesInfoModel() != null)
//		 {
//			 txtTbl = ConvertedHelper.getTxtQuestionTbl(model.getTxtQuesInfoModel());
//		 }
//		 
//		 tbl.setTxtQuesInfoTbl(txtTbl);
//		 
//		 tbl.setUser_quest_ans(model.getUser_quest_ans());
//		 if(model.getUser_quest_id() != null)
//		 {
//			 tbl.setUser_quest_id(model.getUser_quest_id());
//		 }
//		 tbl.setUser_quest_marks(model.getUser_quest_marks());
//		 tbl.setUser_quest_name(model.getUser_quest_name());
//		 tbl.setUser_quest_optionA(model.getUser_quest_optionA());
//		 tbl.setUser_quest_optionB(model.getUser_quest_optionB());
//		 tbl.setUser_quest_optionC(model.getUser_quest_optionC());
//		 tbl.setUser_quest_optionD(model.getUser_quest_optionD());
//		return tbl;
//		 
//	 }
//	 
//	 public static KiUserQuestionModel  getQuestionModel(KiUserQuestTbl tbl)
//	 {
//		 KiUserModel userModel = null;
//		 KiQuizModel quizModel = null;
//		 ImageInfoModel imgModel = null;
//		 KiTxtQuesModel txtModel = null;
//		 KiUserQuestionModel model = new KiUserQuestionModel();
//
//		 if(tbl.getUserInfoTbl() != null)
//		 {
//			 userModel = ConvertedHelper.getUserModel(tbl.getUserInfoTbl());
//		 }
//		 if(tbl.getQuizInfoTbl() != null)
//		 {
//			 quizModel = ConvertedHelper.getQuizModel(tbl.getQuizInfoTbl());
//		 }
//		 
//		 model.setUserModel(userModel);
//		 model.setQuizModel(quizModel);
//		 if(tbl.getImgInfoTbl() != null)
//		 {
//			 imgModel = ConvertedHelper.getImageModel(tbl.getImgInfoTbl());
//		 }
//		 model.setImageInfoModel(imgModel);
//		 if(tbl.getTxtQuesInfoTbl() != null)
//		 {
//			 txtModel = ConvertedHelper.getTxtQuestionModel(tbl.getTxtQuesInfoTbl());
//		 }
//		 
//		 model.setTxtQuesInfoModel(txtModel);
//		 
//		 model.setUser_quest_ans(tbl.getUser_quest_ans());
//		 if(tbl.getUser_quest_id() != null)
//		 {
//			 model.setUser_quest_id(tbl.getUser_quest_id());
//		 }
//		 model.setUser_quest_marks(tbl.getUser_quest_marks());
//		 model.setUser_quest_name(tbl.getUser_quest_name());
//		 model.setUser_quest_optionA(tbl.getUser_quest_optionA());
//		 model.setUser_quest_optionB(tbl.getUser_quest_optionB());
//		 model.setUser_quest_optionC(tbl.getUser_quest_optionC());
//		 model.setUser_quest_optionD(tbl.getUser_quest_optionD());
//		return model;
//		 
//	 }
//	 
//	 public static KiDgrmImgTbl getDgrmTbl(DgrmImageInfoModel model)
//	 {
//		 KiDgrmImgTbl tbl  = new KiDgrmImgTbl();
//		 
//		 tbl.setDgrm_img_desc(model.getDgrm_img_desc());
//		 if(model.getDgrm_img_id() != null)
//		 {
//			 	tbl.setDgrm_img_id(model.getDgrm_img_id());
//		 }
//		 tbl.setDgrm_img_name(model.getDgrm_img_name());
//		 tbl.setDgrm_img_path(model.getDgrm_img_path());
////		 if(model.getKiKidderQuestModel() != null)
////		 {
////			 	tbl.setKiKidderQuesTbl(ConvertedHelper.getKidderQuestTbl(model.getKiKidderQuestModel()));
////		 }
//		 return tbl;
//	 }
//	 
//	 public static DgrmImageInfoModel  getDgrmModel(KiDgrmImgTbl tbl)
//	 {
//		 DgrmImageInfoModel model  = new DgrmImageInfoModel();
//		 
//		 model.setDgrm_img_desc(tbl.getDgrm_img_desc());
//		 if(tbl.getDgrm_img_id() != null)
//		 {
//			 model.setDgrm_img_id(tbl.getDgrm_img_id());
//		 }
//		 model.setDgrm_img_name(tbl.getDgrm_img_name());
//		 model.setDgrm_img_path(tbl.getDgrm_img_path());
////		 if(tbl.getKiKidderQuesTbl() != null)
////		 {
////			 model.setKiKidderQuestModel(ConvertedHelper.getKidderQuestModel((tbl.getKiKidderQuesTbl())));
////		 }
//		 return model;
//	 }
//	 
//}

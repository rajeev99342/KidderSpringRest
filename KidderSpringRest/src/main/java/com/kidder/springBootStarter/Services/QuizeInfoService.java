package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.GroupDetailsModel;
//import com.kidder.Common.ConvertedHelper;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Model.QuizDetailModel;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Model.KiUserQuestionModel;
import com.kidder.springBootStarter.Pojo.KiGroupTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;
import com.kidder.springBootStarter.Repo.QuizeInfoRepository;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

import KidderConstant.TestStatusConstant;

@Service
public class QuizeInfoService {
@Autowired
QuizeInfoRepository quizeRepo;
@Autowired
ImageService imageService;

@Autowired
QuesService quesService;

@Autowired
UserInfoService userService;

@Autowired 
GroupInfoService groupService;

@Autowired

KiKidderQuestService kiQuestService;

	public KiQuizModel saveUserQuiz(KiQuizModel quizModel) throws Exception
	{

		QuizDetailModel quizDetail = new QuizDetailModel();
		
		Set<KiUserQuestTbl> questTbls = new HashSet<>();
		KiQuizeTbl quizTbl = new KiQuizeTbl();

		if(quizModel.getUniqueCode() == null)
		{
			quizTbl.generateId();
			quizTbl.setUniqueCode(GenerateUniqueCode.Generate(quizTbl.getQuizId(), "kqt"));
		}else {
			
			
			quizTbl = quizeRepo.getByUniqueCode(quizModel.getUniqueCode());
		}
			quizTbl.setDeleteFl(false);
			if (quizModel.getquizCreatedDate() == null) 
			{
				long millis=System.currentTimeMillis();  
				quizTbl.setquizCreatedDate(new Timestamp(millis));
			}else {
				quizTbl.setquizCreatedDate(quizModel.getquizCreatedDate());
	
			}
			
			quizTbl.setquizDuration(quizModel.getquizDuration());
			quizTbl.setquizMarks(quizModel.getquizMarks());
			quizTbl.setquizName(quizModel.getquizName());
			quizTbl.setquizPublishedDate(quizModel.getquizPublishedDate());
			quizTbl.setquizStatus(quizModel.getquizStatus());
			quizTbl.setQuizDesc(quizModel.getQuizDesc());
			quizTbl.setUserInfoTbl(userService.saveByModel(quizModel.getUserModel()));
			KiGroupTbl grpTbl = new KiGroupTbl();
			
			grpTbl.setGrp_admin(quizModel.getGrpModel().getGrp_admin());
			grpTbl.setGrp_desc(quizModel.getGrpModel().getGrp_desc());
			grpTbl.setGrp_name(quizModel.getGrpModel().getGrp_name());
			grpTbl.setGrp_id(quizModel.getGrpModel().getGrp_id());
			grpTbl.setUniqueCode(quizModel.getUniqueCode());
			grpTbl.setDeleteFl(false);
			quizTbl.setGrpInfoTbl(groupService.saveGroupByModel(quizModel.getGrpModel()));
			Set<KiKidderQuestTbl> questionTbls = kiQuestService.saveAllQuestByModel(quizModel.getKidderQuestModels(),quizTbl.getQuizId());
			quizTbl.setquizNoOfQuest(questionTbls.size());

			
			quizTbl.setKqtbls(questionTbls);
		

		try {
			KiQuizeTbl quizeTable = quizeRepo.save(quizTbl);
			quizModel.setError(null);
			quizModel.setStatus("Success");
			quizModel.setDeleteFl(quizeTable.getDeleteFl());
			quizModel.setquizCreatedDate(quizeTable.getquizCreatedDate());
			quizModel.setquizDuration(quizeTable.getquizDuration());
			quizModel.setquizId(quizeTable.getQuizId());
			quizModel.setquizMarks(quizeTable.getquizMarks());
			quizModel.setquizName(quizeTable.getquizName());
			quizModel.setquizNoOfQuest(quizeTable.getquizNoOfQuest());
			quizModel.setquizPublishedDate(quizeTable.getquizPublishedDate());
			quizModel.setquizSub(quizeTable.getQuizSub());
			
		}catch(Exception e)
		{
			quizModel.setError(e.getMessage());
			quizModel.setStatus("Failed");
		}
		
		
		return quizModel;
	
	}
	
	public GroupDetailsModel getAllTestByGroupIdAndUsers(long grpId)
	{
		List<KiQuizeTbl> tbls = quizeRepo.getAllTestByGrpId(grpId);
		
		List<KiQuizModel> models = new ArrayList<>();
		
		for(KiQuizeTbl tbl : tbls)
		{
			KiQuizModel model = new KiQuizModel();
			
			model.setDeleteFl(tbl.getDeleteFl());
			model.setquizCreatedDate(tbl.getquizCreatedDate());
			model.setquizPublishedDate(tbl.getquizPublishedDate());
			model.setquizDuration(tbl.getquizDuration());
			model.setquizId(tbl.getQuizId());
			model.setQuizDesc(tbl.getQuizDesc());
			model.setquizMarks(tbl.getquizMarks());
			model.setquizNoOfQuest(tbl.getquizNoOfQuest());
			model.setquizName(tbl.getquizName());
			model.setquizStatus(tbl.getquizStatus());
			models.add(model);
			}
		
		GroupDetailsModel grpDetail = new GroupDetailsModel();
		
		grpDetail.setQuizList(models);
		
		grpDetail.setUserList(userService.getAllUserByGroupId(grpId));
		
		return grpDetail;

	}
	
	
	public List<KiQuizModel>  getAllDraftTest(long grpId)
	{
		List<KiQuizeTbl> tbls = quizeRepo.getAllTestByGrpId(grpId);
		
		List<KiQuizModel> models = new ArrayList<>();
		
		for(KiQuizeTbl tbl : tbls)
		{
			KiQuizModel model = new KiQuizModel();
			
			if(tbl.getDeleteFl() == false)
			{
				
				model.setDeleteFl(tbl.getDeleteFl());
				model.setquizCreatedDate(tbl.getquizCreatedDate());
				model.setquizPublishedDate(tbl.getquizPublishedDate());
				model.setquizDuration(tbl.getquizDuration());
				model.setquizId(tbl.getQuizId());
				model.setquizNoOfQuest(tbl.getquizNoOfQuest());
				model.setquizMarks(tbl.getquizMarks());
				model.setQuizDesc(tbl.getQuizDesc());
				model.setquizName(tbl.getquizName());
				model.setquizStatus(tbl.getquizStatus());
				model.setUniqueCode(tbl.getUnique_code());
				
				KiUserModel userModel = new KiUserModel();
				
				if(tbl.getUserInfoTbl().getDeleteFl() == false)
				{
					userModel.setDeleteFl(tbl.getUserInfoTbl().getDeleteFl());
					userModel.setUniqueCode(tbl.getUserInfoTbl().getUniqueCode());
					userModel.setUser_email(tbl.getUserInfoTbl().getUser_email());
					userModel.setUser_name(tbl.getUserInfoTbl().getUser_name());
					userModel.setUser_fb_id(tbl.getUserInfoTbl().getUser_fb_id());
					userModel.setUser_fb_pic(tbl.getUserInfoTbl().getUser_fb_pic());
					userModel.setUser_type(tbl.getUserInfoTbl().getUser_type());
					userModel.setUser_username(tbl.getUserInfoTbl().getUser_username());
					model.setUserModel(userModel);
				}
				
				
				
				models.add(model);
			}

			}
	
		
		return models;

	}
	
	public KiQuizModel updateTestStatus(String uniqueCode,int status)
	{
		KiQuizeTbl tbl = quizeRepo.getByUniqueCode(uniqueCode);
		KiQuizModel model = new KiQuizModel();
		if(tbl != null)
		{
				if(status == TestStatusConstant.TestStatus.TEST_IN_DRAFT)
				{
					tbl.setquizStatus(TestStatusConstant.TestStatus.TEST_IN_DRAFT);
				}else if(status == TestStatusConstant.TestStatus.TEST_IN_UPCOMMING)
				{
					tbl.setquizStatus(TestStatusConstant.TestStatus.TEST_IN_UPCOMMING);

				}else if(status == TestStatusConstant.TestStatus.TEST_IN_PROGRESS)
				{
					tbl.setquizStatus(TestStatusConstant.TestStatus.TEST_IN_PROGRESS);

				}
			
				KiQuizeTbl quizTbl  = quizeRepo.save(tbl);
				model.setDeleteFl(quizTbl.getDeleteFl());
				model.setError(null);
				model.setStatus("Success");
		}
		return model;
		
	}
	

}

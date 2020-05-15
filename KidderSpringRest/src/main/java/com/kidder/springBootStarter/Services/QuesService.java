package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.UserQuestImgModel;
import com.kidder.springBootStarter.Model.UserQuestionModel;
import com.kidder.springBootStarter.Pojo.GroupInfoTbl;
import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;
import com.kidder.springBootStarter.Repo.QuizeInfoRepository;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

@Service
public class QuesService {

	@Autowired
	ImageService imageService;
	
	@Autowired
	QuizeInfoRepository quizeRepo;

	@Autowired 
	UserQuestInfoRepository userquesRepo;

	
	public UserQuestInfoTbl saveUserQues(UserQuestInfoTbl userQuesInfoTbl)
	{
		return userquesRepo.save(userQuesInfoTbl);
	}
	
	
	
}

package com.kidder.springBootStarter.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.GroupModel;
import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Model.UserGrpInfoModel;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Services.GroupInfoService;
import com.kidder.springBootStarter.Services.QuizeInfoService;
import com.kidder.springBootStarter.Services.TestService;
import com.kidder.springBootStarter.Services.UserGrpService;
import com.kidder.springBootStarter.Services.UserInfoService;

@RestController
public class ApiControllers {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/hello")
	public TestTbl sayHello(@RequestBody TestModel testModel)
	{
		return testService.saveData(testModel);
	}
	@Autowired
	UserInfoService userInfoService;
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public @ResponseBody String saveUserData(@RequestBody UserModel userModel) throws SQLException {
		
		return userInfoService.saveUserDetail(userModel);
	}
	@Autowired
	GroupInfoService groupInfoService;
	@RequestMapping(value = "/saveGroupData", method = RequestMethod.POST)
	public @ResponseBody String saveGroupData(@RequestBody GroupModel groupModel) {
		return groupInfoService.saveGroupDetail(groupModel);
	}
	@Autowired
	QuizeInfoService quizeInfoService;
	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
	public @ResponseBody String saveQuizData(@RequestBody QuizModel quizModel) {
		quizeInfoService.saveQuizDetail(quizModel);
		
		return "";
	}
	@Autowired
	UserGrpService userGrpService;
	@RequestMapping(value = "/grpRequest", method = RequestMethod.POST)
	public @ResponseBody String grpAddRequest(@RequestBody UserGrpInfoModel userGrpInfoModel) {
		if(userGrpInfoModel.isReqstFrmUser()) {
			userGrpService.addUserRqust(userGrpInfoModel);
		} else if(userGrpInfoModel.isReqstFrmGrpAdmin()) {
			userGrpService.updateUserRqustStatus(userGrpInfoModel);
		} else 
			return "Invalid Request";
		return "Request Completed";
	}
}

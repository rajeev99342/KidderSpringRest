package com.kidder.springBootStarter.Controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Services.GroupInfoService;
import com.kidder.springBootStarter.Services.QuizeInfoService;
import com.kidder.springBootStarter.Services.TestService;
import com.kidder.springBootStarter.Services.UserGrpService;
import com.kidder.springBootStarter.Services.UserInfoService;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/api"})
public class ApiControllers {
	
	@Autowired
	TestService testService;
	@Autowired
	GroupInfoService groupInfoService;
	@Autowired
	UserGrpService userGrpService;
	@Autowired
	UserInfoService userInfoService;
	
	
	@RequestMapping("/hello")
	public TestTbl sayHello(@RequestBody TestModel testModel)
	{
		return testService.saveData(testModel);
	}

	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public @ResponseBody UserModel saveUserData(@RequestBody UserModel userModel) throws SQLException {
		
		return userInfoService.saveUserDetail(userModel);
	}
	
	

	@RequestMapping(value = "/saveGroupData", method = RequestMethod.POST)
	public @ResponseBody GroupModel saveGroupData(@RequestBody GroupModel groupModel) {
		return groupInfoService.saveGroupDetail(groupModel);
	}
	@Autowired
	QuizeInfoService quizeInfoService;
	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
	public @ResponseBody QuizModel saveQuizData(@RequestBody QuizModel quizModel) {
		 quizeInfoService.saveQuizDetail(quizModel);
		return null;
		
	}

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
	

//	@RequestMapping(value = "/getGrpByAdmin", method = RequestMethod.POST)
	@GetMapping("/getGrpByAdmin"+"/{admin}"+"/{isMyGroup}")
	public @ResponseBody Set<GroupModel> getGrpByAdmin(@PathVariable(name="admin") String admin,@PathVariable(name="isMyGroup") Boolean isMyGroup) {
		
		return groupInfoService.getGrpByAdmin(admin,isMyGroup);
		
	
	}
	
	@GetMapping("/searchParticipant"+"/{username}")
	public @ResponseBody UserModel getUser(@PathVariable(name="username") String username) {
		
		return userInfoService.getUser(username);
	}

	@GetMapping("/login"+"/{username}"+"/{password}")
	public  @ResponseBody UserModel loginUser(@PathVariable(name="username") String username,@PathVariable(name="password") String password)
	{
		return userInfoService.loginUser(username,password);
	}

}

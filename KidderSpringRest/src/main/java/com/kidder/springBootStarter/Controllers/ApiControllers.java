package com.kidder.springBootStarter.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.ChildModel;
import com.kidder.springBootStarter.Model.GroupDetailsModel;
import com.kidder.springBootStarter.Model.KiGroupModel;
import com.kidder.springBootStarter.Model.KiKidderQuestModel;
import com.kidder.springBootStarter.Model.KidderQuestionModel;
import com.kidder.springBootStarter.Model.ParentModel;
import com.kidder.springBootStarter.Model.QuizDetailModel;
import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Model.UserGrpInfoModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Model.KiUserQuestionModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Repo.ChildRepo;
import com.kidder.springBootStarter.Repo.ParentRepo;
import com.kidder.springBootStarter.Pojo.ChildTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Pojo.ParentTbl;
import com.kidder.springBootStarter.Services.GroupInfoService;
import com.kidder.springBootStarter.Services.KiKidderQuestService;
import com.kidder.springBootStarter.Services.QuizeInfoService;
import com.kidder.springBootStarter.Services.TestRoomService;
//import com.kidder.springBootStarter.Services.QuizeInfoService;
import com.kidder.springBootStarter.Services.TestService;
import com.kidder.springBootStarter.Services.UserInfoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = { "/kidder/api" })
public class ApiControllers {

	@Autowired
	TestService testService;
	@Autowired
	GroupInfoService groupInfoService;

	@Autowired
	UserInfoService userInfoService;
	@Autowired
	QuizeInfoService quizeInfoService;
	@Autowired
	TestRoomService testRoomService;

	@Autowired

	KiKidderQuestService kiQuestService;

	@Transactional
	@RequestMapping("/hello")
	public List<KiUserTbl> sayHello() {

		return userInfoService.getAllUser();
	}

	@Transactional
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public @ResponseBody KiUserModel saveUserData(@RequestBody KiUserModel userModel) throws SQLException {

		return userInfoService.saveUserDetail(userModel);
	}

	@Transactional
	@RequestMapping(value = "/saveGroupData", method = RequestMethod.POST)
	public @ResponseBody KiGroupModel saveGroupData(@RequestBody KiGroupModel groupModel) {
		return groupInfoService.saveGroupDetail(groupModel);
	}

	@Transactional
	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
	public @ResponseBody KiQuizModel saveUserQuiz(@RequestBody KiQuizModel quizModel) throws Exception {

		return quizeInfoService.saveUserQuiz(quizModel);

	}

//	@Autowired
//	QuizeInfoService quizeInfoService;
//	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
//	public @ResponseBody QuizModel saveQuizData(@RequestBody QuizModel quizModel) {
//		 quizeInfoService.saveQuizDetail(quizModel);
//		return null;
//		
//	}
//	@Transactional
//	@RequestMapping(value = "/grpRequest", method = RequestMethod.POST)
//	public @ResponseBody String grpAddRequest(@RequestBody UserGrpInfoModel userGrpInfoModel) {
//		if(userGrpInfoModel.isReqstFrmUser()) {
//			userGrpService.addUserRqust(userGrpInfoModel);
//		} else if(userGrpInfoModel.isReqstFrmGrpAdmin()) {
//			userGrpService.updateUserRqustStatus(userGrpInfoModel);
//		} else 
//			return "Invalid Request";
//		return "Request Completed";
//	}
//	
	@Transactional
//	@RequestMapping(value = "/getGrpByAdmin", method = RequestMethod.POST)
	@GetMapping("/getGrpByAdmin" + "/{admin}" + "/{isMyGroup}")
	public @ResponseBody Set<KiGroupModel> getGrpByAdmin(@PathVariable(name = "admin") String admin,
			@PathVariable(name = "isMyGroup") Boolean isMyGroup) {

		return groupInfoService.getGrpByAdmin(admin, isMyGroup);

	}

	@GetMapping("/login" + "/{username}" + "/{password}")
	public @ResponseBody KiUserModel loginUser(@PathVariable(name = "username") String username,
			@PathVariable(name = "password") String password) {
		return userInfoService.loginUser(username, password);
	}

	@Transactional

	@GetMapping("/getTestRoomsByGroupId" + "/{groupId}")
	public @ResponseBody List<KiQuizModel> getTestRoomsByGroupId(@PathVariable(name = "groupId") long groupId) {

		return testRoomService.getTestRoomByGroupId(groupId);

	}

	@Transactional

	@GetMapping("/getQuestionByQuizId" + "/{quizId}")
	public @ResponseBody Set<KiKidderQuestModel> getQuestions(@PathVariable(name = "quizId") long quizId)
			throws Exception {

		return kiQuestService.getQuestionByQuizId(quizId);

	}
//	

	@Transactional
	@GetMapping("/getGrpsByUserId" + "/{user_id}")
	public @ResponseBody Set<KiGroupModel> getGrpsByUserId(@PathVariable(name = "user_id") long user_id) {


		return groupInfoService.getGrpsByUserId(user_id);

	}

	@Transactional
	@PostMapping("/startTest" + "/{mode}")
	public @ResponseBody KiQuizModel startTest(@PathVariable(name = "mode") String mode,
			@RequestBody KiQuizModel quizModel) {

		return testRoomService.startTest(quizModel, mode);

	}

	@Transactional
	@GetMapping("/fetchTest" + "/{grp_id}")
	public @ResponseBody GroupDetailsModel getGroupDetail(@PathVariable(name = "grp_id") long grp_id) {

		return quizeInfoService.getAllTestByGroupIdAndUsers(grp_id);

	}
	@Transactional
	@GetMapping("/getParticipantByGroup" + "/{grpId}")
	public @ResponseBody List<KiUserModel> getParticipantByGroup(@PathVariable(name = "grpId") long grpId) {

		return userInfoService.getAllUserByGroupId(grpId);
	}
	
	
//	@Transactional
//	@GetMapping("/getDraftTest" + "/{grp_id}")
//	public @ResponseBody List<KiQuizModel> getDraftTest(@PathVariable(name = "grp_id") long grp_id) {
//
//		return quizeInfoService.getAllDraftTest(grp_id);
//
//	}
}

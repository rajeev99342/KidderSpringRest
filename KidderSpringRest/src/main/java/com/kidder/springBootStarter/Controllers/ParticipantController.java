package com.kidder.springBootStarter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Services.GroupParticipantService;
import com.kidder.springBootStarter.Services.UserInfoService;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/api/participant"})
public class ParticipantController {
	
	@Autowired
	GroupParticipantService grpPartiServce;
	
	@Autowired
	UserInfoService userInfoService;
	
	
	
	@GetMapping("/searchUser"+"/{username}")
	public @ResponseBody KiUserModel getKidderUser(@PathVariable(name="username") String username) {
		
		return userInfoService.getUser(username);
	}
	
	
//	@Transactional(propagation = Propagation.NESTED)

	@RequestMapping("/addGrpParticipant")
	public GroupParticipantModel addGrpParticipant(@RequestBody GroupParticipantModel groupPartiModel)
	{
		return grpPartiServce.addParticipant(groupPartiModel,"Participant");
		
	}
	
	@GetMapping("/searchParticipant"+"/{username}")
	public @ResponseBody KiUserModel getUser(@PathVariable(name="username") String username) {
		
		return userInfoService.getUser(username);
	}

}
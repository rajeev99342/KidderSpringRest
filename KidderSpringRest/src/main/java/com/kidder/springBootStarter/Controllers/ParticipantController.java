package com.kidder.springBootStarter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.GroupParticipantModel;
import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Services.GroupParticipantService;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/participant"})
public class ParticipantController {
	
	@Autowired
	GroupParticipantService grpPartiServce;
	
	@Transactional
	@RequestMapping("/addGrpParticipant")
	public GroupParticipantModel addGrpParticipant(@RequestBody GroupParticipantModel groupPartiModel)
	{
		return grpPartiServce.addParticipant(groupPartiModel);
	}
	
}
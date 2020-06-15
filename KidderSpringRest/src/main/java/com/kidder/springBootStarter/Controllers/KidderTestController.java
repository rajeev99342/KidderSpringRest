package com.kidder.springBootStarter.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.KiQuizModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Services.QuizeInfoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/api/kidderTest"})
public class KidderTestController {
	
	@Autowired
	QuizeInfoService quizeInfoService;
	@Autowired
	
	QuizeInfoService testService;
//	
//	@GetMapping("/fetchTest"+"/{grpId}")
//	public @ResponseBody List<KiQuizModel> getUser(@PathVariable(name="grpId") long grpId) {
//		
//		return testService.getAllTestByGroupId(grpId);
//	}
	
	@Transactional
	@GetMapping("/getDraftTest" + "/{grp_id}")
	public @ResponseBody List<KiQuizModel> getDraftTest(@PathVariable(name = "grp_id") long grp_id) {

		return quizeInfoService.getAllDraftTest(grp_id);

	}
	
	@Transactional
	@PostMapping("/updateTestStatus" + "/{status}" )
	public @ResponseBody KiQuizModel updateTestStatus(@RequestBody String uniqueCode,@PathVariable int status) {

		return quizeInfoService.updateTestStatus(uniqueCode,status);

	}
	
	
}

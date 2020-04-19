package com.kidder.springBootStarter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Services.TestService;

@RestController
public class ApiControllers {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/hello")
	public TestTbl sayHello(@RequestBody TestModel testModel)
	{
		return testService.saveData(testModel);
	}
	
}

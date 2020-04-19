package com.kidder.springBootStarter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.TestModel;
import com.kidder.springBootStarter.Pojo.TestTbl;
import com.kidder.springBootStarter.Repo.TestRepository;

@Service
public class TestService {
	
	
	@Autowired
	TestRepository repo;
	
	public TestTbl saveData(TestModel testModel)
	{
		TestTbl testTbl = new TestTbl();
		
		testTbl.setFirst_name(testModel.getFirst_name());
		testTbl.setLast_name(testModel.getLast_name());
		
		return repo.save(testTbl);
			
	}

}

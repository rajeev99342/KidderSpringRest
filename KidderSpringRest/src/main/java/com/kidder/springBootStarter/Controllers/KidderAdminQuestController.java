
package com.kidder.springBootStarter.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.springBootStarter.Model.KiKidderQuestModel;

import com.kidder.springBootStarter.Services.KiKidderQuestService;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/api/kidderAdmin"})
public class KidderAdminQuestController {
	
	@Autowired
	KiKidderQuestService kiKidderQuestService;
	
	
	@Transactional
	@RequestMapping(value = "/saveQuestionByAdmin", method = RequestMethod.POST)
	public @ResponseBody KiKidderQuestModel saveQuestionByAdmin(@RequestBody KiKidderQuestModel kidderQuestModel) throws SQLException {
		return kiKidderQuestService.saveQuestionByAdmin(kidderQuestModel);
	}
	
}
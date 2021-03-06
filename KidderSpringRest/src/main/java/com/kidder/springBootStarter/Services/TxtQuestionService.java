package com.kidder.springBootStarter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.KiTxtQuesModel;
import com.kidder.springBootStarter.Pojo.KiTxtQuestTbl;
import com.kidder.springBootStarter.Repo.TxtQuestionRepository;


@Service
public class TxtQuestionService {

	@Autowired
	TxtQuestionRepository txtQuesRepo;
	
	public KiTxtQuestTbl saveTxtQuest(KiTxtQuestTbl txtQues)
	{
		KiTxtQuestTbl txtQuesTbl = null;
		KiTxtQuesModel txtQuesModel = new KiTxtQuesModel();
		if(txtQues != null)
		{
			txtQuesTbl = txtQuesRepo.save(txtQues);
			
//			txtQuesModel.setQuesTxt(txtQues.getQuesTxt());
//			txtQuesModel.setTxt_ques_id(txtQues.getTxt_ques_id());
			
		}
		return txtQuesTbl;
	}
	
	public KiTxtQuestTbl getByUniqueCode(String uniqueCode)
	{
		return txtQuesRepo.getByUniqueCode(uniqueCode);
	}
	
	public KiTxtQuestTbl saveTxtQuestByModel(KiTxtQuesModel model) {
		 KiTxtQuestTbl txtQuest = new KiTxtQuestTbl();

		 if(model.getUniqueCode() != null)
		 {
			 //edit case
			 
			 txtQuest = txtQuesRepo.getByUniqueCode(model.getUniqueCode());
			 
		 }else {
			 
			 txtQuest.generateId(); 
			 
			 txtQuest.setUniqueCode(GenerateUniqueCode.Generate(txtQuest.getTxt_ques_id(), "kitxtquest"));
		 
			 
		 }
		 
		 txtQuest.setDeleteFl(false);
		 txtQuest.setQuesTxt(model.getQuesTxt());

		 return txtQuesRepo.save(txtQuest);
		 
		 
	}
	
	public KiTxtQuesModel getTxtQuestModel(KiTxtQuestTbl tbl)
	{
		KiTxtQuesModel model = null;
		if(tbl != null)
		{
			model = new KiTxtQuesModel();
			model.setDeleteFl(tbl.getDeleteFl());
			model.setQuesTxt(tbl.getQuesTxt());
			model.setUniqueCode(tbl.getUniqueCode());
			model.setTxt_ques_id(tbl.getTxt_ques_id());
			
		}
		return model;
	}
	
}


package com.kidder.springBootStarter.Controllers;

import java.io.File;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidder.Common.GetBase64ImageFromFile;
import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
import com.kidder.springBootStarter.Model.KiKidderQuestModel;
import com.kidder.springBootStarter.Model.KiTxtQuesModel;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Services.KiKidderQuestService;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value= {"/kidder/api/kidderAdmin"})
public class KidderAdminQuestController {
	
	@Autowired
	KiKidderQuestService kiKidderQuestService;
	
	
	@Transactional
	@RequestMapping(value = "/saveQuestionByAdmin", method = RequestMethod.POST)
	public @ResponseBody KiKidderQuestModel saveQuestionByAdmin(@RequestBody KiKidderQuestModel kidderQuestModel) throws Exception {
		KiKidderQuestTbl tbl =  kiKidderQuestService.saveQuestionByAdmin(kidderQuestModel);
		KiKidderQuestModel model = new KiKidderQuestModel();
		model.setDeleteFl(tbl.getDeleteFl());
		Set<DgrmImageInfoModel> dgrmModels = new HashSet<>();
		if(tbl.getDgrmImgInfoTbls().size() != 0)
		{
			for(KiDgrmImgTbl dgrmTbl : tbl.getDgrmImgInfoTbls())
			{
				DgrmImageInfoModel dgrmModel = new DgrmImageInfoModel();
				dgrmModel.setDeleteFl(dgrmTbl.getDeleteFl());
				File newFile = new File(dgrmTbl.getDgrm_img_path());

				dgrmModel.setDgrm_img_base64(GetBase64ImageFromFile.encodeFileToBase64Binary(newFile));
				dgrmModel.setUniqueCode(dgrmTbl.getUniqueCode());
				dgrmModel.setDgrm_img_id(dgrmTbl.getDgrm_img_id());
				dgrmModels.add(dgrmModel);
			}
		}
		model.setDgrmImageInfoModels(dgrmModels);
		
		KiUserModel user = new KiUserModel();
		user.setDeleteFl(tbl.getUserInfoTbl().getDeleteFl());
		user.setUniqueCode(tbl.getUserInfoTbl().getUniqueCode());
		user.setUser_username(tbl.getUserInfoTbl().getUser_username());
		model.setUserModel(user);
		KiTxtQuesModel kitxtModel = new KiTxtQuesModel();
		kitxtModel.setDeleteFl(tbl.getTxtQuesInfoTbl().getDeleteFl());
		kitxtModel.setQuesTxt(tbl.getTxtQuesInfoTbl().getQuesTxt());
		kitxtModel.setUniqueCode(tbl.getTxtQuesInfoTbl().getUniqueCode());
		kitxtModel.setTxt_ques_id(tbl.getTxtQuesInfoTbl().getTxt_ques_id());
		model.setTxtQuesInfoModel(kitxtModel);
		
		return model;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/getQuestByAdmin"+"/"+"{username}", method = RequestMethod.GET)
	public @ResponseBody Set<KiKidderQuestModel> getQuestByAdmin(@PathVariable String username) throws Exception
	{
		
		Set<KiKidderQuestModel> models = new HashSet<>();
		try {
			return kiKidderQuestService.getQuestionByAdmin(username);

		}catch (Exception e) {
			// TODO: handle exception
			KiKidderQuestModel model = new KiKidderQuestModel();
			model.setError(true);
			model.setStatus(e.getMessage());
			 models.add(model);
			 return models;
		}
		
	}
	
}
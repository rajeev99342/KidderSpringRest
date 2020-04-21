package com.kidder.springBootStarter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.UserQuestImgModel;
import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
import com.kidder.springBootStarter.Repo.ImageInfoRepository;

@Service
public class ImageInfoService {
@Autowired
ImageInfoRepository imageInfoRepository;
@Autowired
ImageInfoTbl imageInfoTbl;

public ImageInfoTbl insert(UserQuestImgModel userQuestImgModel) {
	String imgName = CommonResource.randomString(5).toUpperCase();
	if(userQuestImgModel.getUser_quest_img_base64_url()!=null) {
		userQuestImgModel.setUser_quest_img_path(CommonResource.StoreBase64Image(userQuestImgModel.getUser_quest_img_base64_url(), imgName));
		userQuestImgModel.setUser_quest_img_name(imgName);	

		SetParams(userQuestImgModel);
		return imageInfoRepository.save(imageInfoTbl);
	}
	return null;
}
public void SetParams(UserQuestImgModel userQuestImgModel) {
	imageInfoTbl.setImg_id(userQuestImgModel.getUser_quest_img_id());
	imageInfoTbl.setImg_name(userQuestImgModel.getUser_quest_img_name());
	imageInfoTbl.setImg_desc(userQuestImgModel.getUser_quest_img_desc());
	imageInfoTbl.setImg_path(userQuestImgModel.getUser_quest_img_path());
	imageInfoTbl.setIs_dgrm_img(userQuestImgModel.isUser_quest_img_isDgrm());
	imageInfoTbl.setIs_quest_img(userQuestImgModel.isUser_quest_img_isQuest());
}
}

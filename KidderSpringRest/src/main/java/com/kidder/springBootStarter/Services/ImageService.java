package com.kidder.springBootStarter.Services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.Common.DeleteImageHelper;
import com.kidder.Common.GenerateUniqueCode;
import com.kidder.Common.GetImagePathFromBase64;
import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Repo.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepo;
	
	public KiImgTbl saveQuesImage(ImageInfoModel imgeInfoModel)
	{
		KiImgTbl mTbl = null; 
			if(imgeInfoModel != null)
			{
				KiImgTbl tbl = new KiImgTbl();
				if(imgeInfoModel.getImg_id() != null)
				{
					DeleteImageHelper.delete(new File(imgeInfoModel.getImg_path()));
					tbl.setImg_id(imgeInfoModel.getImg_id());
				}
				
				
				tbl.setImg_base64(null);
				tbl.setImg_desc(imgeInfoModel.getImg_desc());
				tbl.setImg_name("name");
				tbl.setImg_path(CommonResource.StoreBase64Image(imgeInfoModel.getImg_base64(), CommonResource.randomString(5).toUpperCase()));
				
				long count = imageRepo.findAll().size();
				
				tbl.setUnique_code("image_info_tbl"+count);
				
				mTbl =  imageRepo.save(tbl);
				
			}
			return mTbl;
	}
	public KiImgTbl saveQuestImageByModel(ImageInfoModel imgModel,long questId)
	{
		
		KiImgTbl imgTbl = new KiImgTbl();
		
		if(imgModel.getUniqueCode() == null)
		{
			imgTbl.generateId();
			imgTbl.setUnique_code(GenerateUniqueCode.Generate(imgTbl.getImg_id(), "kit"));
			imgTbl.setImg_name(GenerateUniqueCode.Generate(imgTbl.getImg_id(), "kit"));
			imgTbl.setImg_path(GetImagePathFromBase64.getImagePath(imgModel));
			
		}else {
			imgTbl.setUnique_code(imgModel.getUniqueCode());
			imgTbl.setImg_id(imgModel.getImg_id());
		}
		
		imgTbl.setDeleteFl(false);
		imgTbl.setImg_base64(imgModel.getImg_base64());
		imgTbl.setImg_desc(imgModel.getImg_desc());
		imgTbl.setImg_name(imgModel.getImg_name());
		imgTbl.setImg_path(imgModel.getImg_path());
		imgTbl.setUser_quest_id(questId);
		return imageRepo.save(imgTbl);
		
	}
	
	public Set<KiImgTbl> saveAllQuestImages(Set<ImageInfoModel> imgQuestModels,long questId)
	{
		List<KiImgTbl> dgrms = new ArrayList<>();
		 for(ImageInfoModel drgm : imgQuestModels)
		 {
			 KiImgTbl imgTable = new KiImgTbl();

			 if(drgm.getUniqueCode() != null)
			 {
				 imgTable = imageRepo.getImgQuestByUniqueCode(drgm.getUniqueCode());
		
			 }else {
				 imgTable.generateId();
				 imgTable.setUniqueCode(GenerateUniqueCode.Generate(imgTable.getImg_id(), "kit"));
				 imgTable.setImg_name(GenerateUniqueCode.Generate(imgTable.getImg_id(), "kit"));

			 }
			 
			 if(drgm.getToBeDeleted())
			 {
				 DeleteImageHelper.delete(new File(drgm.getImg_path()));
				 imgTable.setImg_path(drgm.getImg_path());
				 imgTable.setDeleteFl(true);
				 imgTable.setImg_base64(null);
				 imgTable.setImg_name(drgm.getImg_name());;
				 imageRepo.delete(imgTable);
			 }else {
				 if(drgm.getUniqueCode() != null)
				 {
					 imgTable.setImg_path(drgm.getImg_path());
					 imgTable.setDeleteFl(false);
					 imgTable.setImg_base64(null);
					 imgTable.setImg_name(drgm.getImg_name());
					 dgrms.add(imgTable); 
				 }else {
					 imgTable.setImg_path(GetImagePathFromBase64.getImagePath(drgm));
					 imgTable.setDeleteFl(false);
					 imgTable.setImg_base64(null);
					 imgTable.setUser_quest_id(questId);
					 dgrms.add(imgTable); 
				 }
		
			 }

		 }
//		 
		 
		
		List<KiImgTbl> dgrmImages =  imageRepo.saveAll(dgrms);
		Set<KiImgTbl> imageDgrmSet  = new HashSet<>();
		for(KiImgTbl kiDgrmImgTbl : dgrmImages)
		{
			imageDgrmSet.add(kiDgrmImgTbl);
		}
		return imageDgrmSet;
	}
	
}

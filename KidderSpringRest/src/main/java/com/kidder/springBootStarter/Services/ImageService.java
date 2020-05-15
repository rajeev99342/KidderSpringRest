package com.kidder.springBootStarter.Services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.Common.DeleteImageHelper;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
import com.kidder.springBootStarter.Repo.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepo;
	
	public ImageInfoTbl saveQuesImage(ImageInfoModel imgeInfoModel)
	{
		ImageInfoTbl mTbl = null; 
			if(imgeInfoModel != null)
			{
				ImageInfoTbl tbl = new ImageInfoTbl();
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
	
}

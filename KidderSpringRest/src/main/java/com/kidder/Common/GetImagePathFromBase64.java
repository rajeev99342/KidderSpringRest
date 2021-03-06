package com.kidder.Common;

import java.io.File;

import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
import com.kidder.springBootStarter.Model.ImageInfoModel;
import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;

public class GetImagePathFromBase64 {
	public static String getImagePath(DgrmImageInfoModel dgrm )
	{
		String  path = null; 
		KiDgrmImgTbl tbl = new KiDgrmImgTbl();

		if(dgrm != null)
		{
//			if(dgrm.getUniqueCode() != null)
//			{
//				DeleteImageHelper.delete(new File(dgrm.getDgrm_img_path()));
//			}
	
			path = CommonResource.StoreBase64Image(dgrm.getDgrm_img_base64(), dgrm.getDgrm_img_name());
			
		}
		return path;
	}
	public static String getImagePath(ImageInfoModel img )
	{
		String  path = null; 
		KiDgrmImgTbl tbl = new KiDgrmImgTbl();

		
		if(img != null)
		{
//			if(dgrm.getUniqueCode() != null)
//			{
//				DeleteImageHelper.delete(new File(dgrm.getDgrm_img_path()));
//			}
	
			path = CommonResource.StoreBase64Image(img.getImg_base64(), img.getImg_name());
			
		}
		return path;
	}
}

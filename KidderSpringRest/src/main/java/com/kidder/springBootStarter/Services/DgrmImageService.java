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
import com.kidder.Common.GetBase64ImageFromFile;
import com.kidder.Common.GetImagePathFromBase64;
import com.kidder.springBootStarter.Model.DgrmImageInfoModel;
import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;
import com.kidder.springBootStarter.Pojo.KiImgTbl;
import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;
import com.kidder.springBootStarter.Repo.DgrmImageRepository;

@Service
public class DgrmImageService {

	@Autowired
	DgrmImageRepository dgrmImgRepo;
	
//	public DgrmImageInfoTbl saveDgrm(DgrmImageInfoModel imgeInfoModel)
//	{
//		DgrmImageInfoTbl mTbl = null; 
//		if(imgeInfoModel != null)
//		{
//			DgrmImageInfoTbl tbl = new DgrmImageInfoTbl();
//			if(imgeInfoModel.getDgrm_img_id() != null)
//			{
//				DeleteImageHelper.delete(new File(imgeInfoModel.getDgrm_img_path()));
//				tbl.setDgrm_img_id(imgeInfoModel.getDgrm_img_id());
//			}
//			
//			
//			tbl.setDgrm_img_desc(imgeInfoModel.getDgrm_img_desc());
//			tbl.setDgrm_img_name(imgeInfoModel.getDgrm_img_name());
//			tbl.setDgrm_img_path(CommonResource.StoreBase64Image(imgeInfoModel.getImg_base64(), imgeInfoModel.getDgrm_img_name()));
//			
//			
//			
//			mTbl = dgrmImgRepo.save(tbl);
//		}
//		return mTbl;
//			
//	}
	
	public List<KiDgrmImgTbl> getDgrmByKidderQuestId(Long kidderQuestId)
	{
//		return dgrmImgRepo.getDgrmByKidderQuestId(kidderQuestId);
		return null;
	}
	
	public Set<KiDgrmImgTbl> saveAllDgrm(Set<DgrmImageInfoModel> dgrmImageInfoModels,KiKidderQuestTbl kikidderQuest)
	{
		List<KiDgrmImgTbl> dgrms = new ArrayList<>();
		 for(DgrmImageInfoModel drgm : dgrmImageInfoModels)
		 {
			KiDgrmImgTbl kidgrmTbl = new KiDgrmImgTbl();

			 if(drgm.getUniqueCode() != null)
			 {
				 kidgrmTbl = dgrmImgRepo.getDgrmByUniqueCode(drgm.getUniqueCode());
		
			 }else {
				 kidgrmTbl.generateId();
				 kidgrmTbl.setUniqueCode(GenerateUniqueCode.Generate(kidgrmTbl.getDgrm_img_id(), "kdit"));
			 }
			 
			 if(drgm.getToBeDeleted())
			 {
				 DeleteImageHelper.delete(new File(drgm.getDgrm_img_path()));
				 kidgrmTbl.setDgrm_img_path(drgm.getDgrm_img_path());
				 kidgrmTbl.setDeleteFl(true);
				 kidgrmTbl.setDgrm_img_base64(null);
				 kidgrmTbl.setDgrm_img_name(drgm.getDgrm_img_name());
				 dgrmImgRepo.delete(kidgrmTbl);
			 }else {
				 if(drgm.getUniqueCode() != null)
				 {
					 kidgrmTbl.setDgrm_img_path(drgm.getDgrm_img_path());
					 kidgrmTbl.setDeleteFl(false);
					 kidgrmTbl.setDgrm_img_base64(null);
					 kidgrmTbl.setDgrm_img_name(drgm.getDgrm_img_name());
					 dgrms.add(kidgrmTbl); 
				 }else {
					 kidgrmTbl.setDgrm_img_path(GetImagePathFromBase64.getImagePath(drgm));
					 kidgrmTbl.setDeleteFl(false);
					 kidgrmTbl.setDgrm_img_base64(null);
					 kidgrmTbl.setKi_kidder_quest_id(kikidderQuest.getKi_kidder_quest_id());
					 kidgrmTbl.setDgrm_img_name(drgm.getDgrm_img_name());
					 dgrms.add(kidgrmTbl); 
				 }
		
			 }

		 }
//		 
		 
		
		List<KiDgrmImgTbl> dgrmImages =  dgrmImgRepo.saveAll(dgrms);
		Set<KiDgrmImgTbl> imageDgrmSet  = new HashSet<>();
		for(KiDgrmImgTbl kiDgrmImgTbl : dgrmImages)
		{
			imageDgrmSet.add(kiDgrmImgTbl);
		}
		return imageDgrmSet;
	}
	
	public Set<DgrmImageInfoModel> getDgrmModels(Set<KiDgrmImgTbl> imgTbls) throws Exception
	{
		Set<DgrmImageInfoModel> models = new HashSet<>();
		for(KiDgrmImgTbl tbl : imgTbls)
		{
			
			if(tbl.getDeleteFl() == false)
			{
				DgrmImageInfoModel model = new DgrmImageInfoModel();
				
				model.setDeleteFl(tbl.getDeleteFl());
				File imgFile = new File(tbl.getDgrm_img_path());
				model.setDgrm_img_base64(GetBase64ImageFromFile.encodeFileToBase64Binary(imgFile));
				model.setDgrm_img_desc(tbl.getDgrm_img_desc());
				model.setDgrm_img_id(tbl.getDgrm_img_id());
				model.setDgrm_img_name(tbl.getDgrm_img_name());
				model.setUniqueCode(tbl.getUniqueCode());
				model.setDgrm_img_path(tbl.getDgrm_img_path());
				models.add(model);
			}

		}
		return models;
	}
	
}

package com.kidder.springBootStarter.Model;

import java.util.List;

public class KidderQuestionModel {

	private KiKidderQuestModel kiKidderQuestModel;
	private List<DgrmImageInfoModel> dgrmImages;
	
	public List<DgrmImageInfoModel> getDgrmImages() {
		return dgrmImages;
	}
	public void setDgrmImages(List<DgrmImageInfoModel> dgrmImages) {
		this.dgrmImages = dgrmImages;
	}
	public KiKidderQuestModel getKiKidderQuestModel() {
		return kiKidderQuestModel;
	}
	public void setKiKidderQuestModel(KiKidderQuestModel kiKidderQuestModel) {
		this.kiKidderQuestModel = kiKidderQuestModel;
	} 
	
	
}

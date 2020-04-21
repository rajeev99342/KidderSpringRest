package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.UserGrpInfoModel;
import com.kidder.springBootStarter.Model.UserGrpReqstStatusInfoModel;
import com.kidder.springBootStarter.Pojo.GrpReqstTbl;
import com.kidder.springBootStarter.Repo.UserGrpRepository;

@Service
public class UserGrpService {
	@Autowired
	UserGrpRepository userGrpRepository;
	@Autowired
	GrpReqstTbl grpReqstTbl;
	
	private Timestamp createDate;
	private Timestamp lastModifiedDate;
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public void addUserRqust(UserGrpInfoModel userGrpInfoModel) {
		long millis=System.currentTimeMillis(); 
		setCreateDate(new Timestamp(millis));
		setLastModifiedDate(new Timestamp(millis));
		SetParams(userGrpInfoModel);
		userGrpRepository.save(grpReqstTbl);
	}
	public void SetParams(UserGrpInfoModel userGrpInfoModel) {
		grpReqstTbl.setGrp_name(userGrpInfoModel.getGrp_name());
		grpReqstTbl.setGrp_reqst_status(userGrpInfoModel.getGrp_reqst_status());
		grpReqstTbl.setUser_username(userGrpInfoModel.getUser_username());
		grpReqstTbl.setGrp_reqst_id(userGrpInfoModel.getGrp_reqst_id());
		grpReqstTbl.setGrp_reqst_date(getCreateDate());
		grpReqstTbl.setGrp_reqst_lst_modified(getLastModifiedDate());
	}
	public void updateUserRqustStatus(UserGrpInfoModel userGrpInfoModel) {
//		userGrpInfoModel.getUser_list()
		long millis=System.currentTimeMillis(); 
		setLastModifiedDate(new Timestamp(millis));
		for(UserGrpReqstStatusInfoModel userList:userGrpInfoModel.getUser_list()) {
			userGrpRepository.updateReqstStatus(userList.getGrp_reqst_status(), getLastModifiedDate(), userList.getUser_username(), userGrpInfoModel.getGrp_admin());
		}
	}
}

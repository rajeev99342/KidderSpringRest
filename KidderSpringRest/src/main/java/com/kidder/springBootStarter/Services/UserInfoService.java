package com.kidder.springBootStarter.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Repo.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	UserInfoTbl userInfoTbl;
	
	
	public String saveUserDetail(UserModel userModel) {
		if(userInfoRepository.getUserDetailsByUserName(userModel.getUser_username()).size() == 0) {
			if(userModel.getUser_unique_code() == null) {
				userModel.setUser_unique_code(CommonResource.randomString((20 - userModel.getUser_username().length())) + userModel.getUser_username().toUpperCase());
			}
			SetParams(userModel);
			userInfoRepository.save(userInfoTbl);
			return "Registration Succesfully";
		} 
		return "UserName Alredy Exists";
		
	}

	
	public void SetParams(UserModel userModel) {
		userInfoTbl.setUser_name(userModel.getUser_name());
		userInfoTbl.setUser_email(userModel.getUser_email());
		userInfoTbl.setUser_password(userModel.getUser_password());
		userInfoTbl.setUser_username(userModel.getUser_username());
		userInfoTbl.setUser_unique_code(userModel.getUser_unique_code());
		userInfoTbl.setUser_phone_number(userModel.getUser_phone_number());
	}


}

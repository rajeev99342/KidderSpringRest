package com.kidder.springBootStarter.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CheckTable;
import com.kidder.Common.CommonResource;
import com.kidder.springBootStarter.Model.UserModel;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;
import com.kidder.springBootStarter.Repo.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepository;

	public UserModel saveUserDetail(UserModel userModel) throws SQLException{
		
		
		
		if(CheckTable.isTableExist("user_info_tbl"))
		{
			if (userInfoRepository.getUserDetailsByUserName(userModel.getUser_username()).size() == 0) {
				return this.saveUserDetails(userModel);
			}else {
				userModel = new UserModel();
				userModel.setError("Username already exits");
				userModel.setStatus("Failed");
				
				return userModel;
			}
			
		}else {
			return this.saveUserDetails(userModel);
		}
	
		

	}

	public UserInfoTbl SetParams(UserModel userModel) {
		UserInfoTbl userInfoTbl = new UserInfoTbl();
		userInfoTbl.setUser_name(userModel.getUser_name());
		userInfoTbl.setUser_email(userModel.getUser_email());
		userInfoTbl.setUser_password(userModel.getUser_password());
		userInfoTbl.setUser_username(userModel.getUser_username());
		userInfoTbl.setUser_unique_code(userModel.getUser_unique_code());
		userInfoTbl.setUser_phone_number(userModel.getUser_phone_number());
		return userInfoTbl;
	}
	
	public UserModel saveUserDetails(UserModel userModel)
	{
		if (userModel.getUser_unique_code() == null) {
			userModel.setUser_unique_code(CommonResource.randomString((20 - userModel.getUser_username().length()))
					+ userModel.getUser_username().toUpperCase());
		}
		UserInfoTbl returnedUserInfoTbl;

		UserInfoTbl userInfoTbl2 = SetParams(userModel);
		try {
			userModel = new UserModel();
			returnedUserInfoTbl = userInfoRepository.save(userInfoTbl2);
			userModel.setUser_email(returnedUserInfoTbl.getUser_email());
			userModel.setUser_name(returnedUserInfoTbl.getUser_name());
			userModel.setUser_id(returnedUserInfoTbl.getUser_id());
			userModel.setUser_unique_code(returnedUserInfoTbl.getUser_unique_code());
			userModel.setUser_username(returnedUserInfoTbl.getUser_username());
			userModel.setStatus("Success");
			userModel.setError(null);

		} catch (Exception e) {
			userModel = new UserModel();
			userModel.setStatus("Failed");
			userModel.setError(e.getMessage());
			// TODO: handle exception

		}

		return userModel;
	}

	public UserModel getUser(String username) {
		UserModel model = new UserModel();

		try {
			UserInfoTbl tbl = userInfoRepository.getUserByUsername(username);

			if (tbl != null) {
				model.setError(null);
				model.setStatus("Success");
				model.setUser_email(tbl.getUser_email());
				model.setUser_name(tbl.getUser_name());
				model.setUser_id(tbl.getUser_id());
				model.setUser_unique_code(tbl.getUser_unique_code());
				model.setUser_phone_number(tbl.getUser_phone_number());
				model.setUser_username(tbl.getUser_username());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.setError(e.getMessage());
			model.setStatus("Failed");
		}

		return model;
	}

	public UserModel loginUser(String user_username, String user_password) {
		UserModel model = new UserModel();

		try {

			UserInfoTbl tbl = userInfoRepository.loginUser(user_username);

			if (tbl != null) {
				if (!user_password.equals(tbl.getUser_password())) {
					model.setError("Incorrect password");
					model.setStatus("Failed");
				} else {
					model.setError(null);
					model.setStatus("Success");
					model.setUser_email(tbl.getUser_email());
					model.setUser_id(tbl.getUser_id());
					model.setUser_name(tbl.getUser_name());
					model.setUser_username(tbl.getUser_username());
					model.setUser_phone_number(tbl.getUser_phone_number());
					model.setUser_unique_code(tbl.getUser_unique_code());
				}

			} else {
				model.setError("Incorrect username");
				model.setStatus("Failed");
			}

			return model;

		} catch (Exception e) {
			// TODO: handle exception
			model.setError(e.getMessage());
			model.setStatus("Failed");
			return null;
		}
	}

}

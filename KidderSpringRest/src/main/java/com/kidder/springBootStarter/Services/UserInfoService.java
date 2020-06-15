package com.kidder.springBootStarter.Services;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.Common.CheckTable;
import com.kidder.Common.GenerateUniqueCode;
import com.kidder.springBootStarter.Model.KiUserModel;
import com.kidder.springBootStarter.Pojo.KiGroupParticipantTbl;
import com.kidder.springBootStarter.Pojo.KiUserTbl;
import com.kidder.springBootStarter.Repo.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	GroupParticipantService grpParticipantService ;

	public KiUserModel saveUserDetail(KiUserModel userModel) throws SQLException {

		KiUserModel model = new KiUserModel();
		KiUserTbl tbl = new KiUserTbl();

		if (CheckTable.isTableExist("ki_user_tbl")) {
			if (userInfoRepository.getUserDetailsByUserName(userModel.getUser_username()).size() == 0) {
				tbl = this.saveByModel(userModel);
			} else {
				userModel = new KiUserModel();
				userModel.setError("Username already exits");
				userModel.setStatus("Failed");

				model = userModel;
				return model;
			}

		} else {
			tbl = this.saveByModel(userModel);
		}

		if (tbl != null) {
			model.setDeleteFl(tbl.getDeleteFl());
			model.setError(null);
			model.setStatus("Success");
			model.setUniqueCode(tbl.getUniqueCode());
			model.setUser_email(tbl.getUser_email());
			model.setUser_id(tbl.getUser_id());
			model.setUser_name(tbl.getUser_name());
			model.setUser_username(tbl.getUser_username());
			model.setUser_token(tbl.getUser_token());
			model.setUser_password(tbl.getUser_password());
			model.setUser_phone_number(tbl.getUser_phone_number());
		}
		return model;

	}

	public KiUserTbl SetParams(KiUserModel userModel) {
		KiUserTbl userInfoTbl = new KiUserTbl();
		userInfoTbl.setUser_name(userModel.getUser_name());
		userInfoTbl.setUser_email(userModel.getUser_email());
		userInfoTbl.setUser_password(userModel.getUser_password());
		userInfoTbl.setUser_username(userModel.getUser_username());
		userInfoTbl.setUser_token(userModel.getUser_token());
		userInfoTbl.setUser_phone_number(userModel.getUser_phone_number());
		return userInfoTbl;
	}

	public KiUserModel saveUserDetails(KiUserModel userModel) {
		KiUserTbl userInfoTbl = new KiUserTbl();

		if (userModel.getUniqueCode() != null) {

		} else {

		}
		KiUserTbl returnedUserInfoTbl;

		KiUserTbl userInfoTbl2 = SetParams(userModel);
		try {
			userModel = new KiUserModel();
			returnedUserInfoTbl = userInfoRepository.save(userInfoTbl2);
			userModel.setUser_email(returnedUserInfoTbl.getUser_email());
			userModel.setUser_name(returnedUserInfoTbl.getUser_name());
			userModel.setUser_id(returnedUserInfoTbl.getUser_id());
			userModel.setUser_token(returnedUserInfoTbl.getUser_token());
			userModel.setUser_username(returnedUserInfoTbl.getUser_username());
			userModel.setStatus("Success");
			userModel.setError(null);

		} catch (Exception e) {
			userModel = new KiUserModel();
			userModel.setStatus("Failed");
			userModel.setError(e.getMessage());
			// TODO: handle exception

		}

		return userModel;
	}

	public KiUserModel getUser(String username) {
		KiUserModel model = new KiUserModel();

		try {
			KiUserTbl tbl = userInfoRepository.getUserByUsername(username);

			if (tbl != null) {
				model.setError(null);
				model.setStatus("Success");
				model.setUser_email(tbl.getUser_email());
				model.setUser_name(tbl.getUser_name());
				model.setUniqueCode(tbl.getUniqueCode());
				model.setUser_id(tbl.getUser_id());
				model.setUser_phone_number(tbl.getUser_phone_number());
				model.setUser_token(tbl.getUser_token());
				model.setUser_username(tbl.getUser_username());
			}else {
				model = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.setError(e.getMessage());
			model.setStatus("Failed");
		}

		return model;
	}

	public KiUserModel loginUser(String user_username, String user_password) {
		KiUserModel model = new KiUserModel();

		try {

			KiUserTbl tbl = userInfoRepository.loginUser(user_username);

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
					model.setUser_token(tbl.getUser_token());
					model.setUniqueCode(tbl.getUniqueCode());
					model.setUser_phone_number(tbl.getUser_phone_number());
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

	public List<KiUserTbl> getAllUser() {

		return userInfoRepository.findAll();
	}

	public KiUserTbl saveByModel(KiUserModel userMode) {
		KiUserTbl userTbl = new KiUserTbl();
		userTbl = userInfoRepository.getUserByUsername(userMode.getUser_username());
		if (userTbl != null) {
			userTbl = userInfoRepository.getUserByUsername(userMode.getUser_username());
		} else {
			userTbl = new KiUserTbl();
			userTbl.generateId();
			userTbl.setUniqueCode(GenerateUniqueCode.Generate(userTbl.getUser_id(), "ki_user_tbl"));
			userTbl.setUser_password(userMode.getUser_password());
			userTbl.setUser_email(userMode.getUser_email());
			userTbl.setUser_name(userMode.getUser_name());
			userTbl.setDeleteFl(false);
			userTbl.setUser_phone_number(userMode.getUser_phone_number());
			userTbl.setUser_username(userMode.getUser_username());
			userTbl.setUser_token(userMode.getUser_token());
		}
		
		return userInfoRepository.save(userTbl);
	}

	public List<KiUserModel> getAllUserByGroupId(long grpId) {

		List<KiGroupParticipantTbl> grpParticipants = grpParticipantService.getUserByGroupId(grpId);
		
		List<Long> userIds = new ArrayList<>();
		List<KiUserTbl> tbls = new ArrayList<>();
		List<KiUserModel> models = new ArrayList<KiUserModel>();

		for(KiGroupParticipantTbl grp : grpParticipants)
		{
			
			KiUserTbl tbl = userInfoRepository.getuserByUserId(grp.getUserInfoTb().getUser_id());
			KiUserModel model = new KiUserModel();
			
			
			model.setDeleteFl(tbl.getDeleteFl());
			model.setUniqueCode(tbl.getUniqueCode());
			model.setUser_username(tbl.getUser_username());
			model.setUser_token(tbl.getUser_token());
			model.setUser_email(tbl.getUser_email());
			model.setUser_id(tbl.getUser_id());
			model.setAdmin(grp.getIsAdmin());
			model.setUser_name(tbl.getUser_name());
			models.add(model);
			
		}

		return models;
	}

}

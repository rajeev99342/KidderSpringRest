package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoTbl,Long>{
	//public String saveUserDetail(UserModel userModel);
	@Query("from UserInfoTbl uit where uit.user_username = :userName")
	public List<UserInfoTbl> getUserDetailsByUserName(String userName);
	//public void SetParams(UserModel userModel);
}

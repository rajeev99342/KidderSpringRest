package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kidder.springBootStarter.Pojo.UserInfoTbl;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoTbl,Long>{
	//public String saveUserDetail(UserModel userModel);
	@Query("from UserInfoTbl uit where uit.user_username = :user_username")
	public List<UserInfoTbl> getUserDetailsByUserName(@Param("user_username") String user_username);
	
	@Query("from UserInfoTbl uit where uit.user_username = :user_username")
	public UserInfoTbl getUserByUsername(@Param("user_username") String user_username);
	
	
	@Query("from UserInfoTbl uit where uit.user_username = :user_username")
	public UserInfoTbl loginUser(@Param("user_username") String user_username);
	
}

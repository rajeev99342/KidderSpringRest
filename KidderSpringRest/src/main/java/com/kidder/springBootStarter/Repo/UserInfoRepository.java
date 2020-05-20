package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kidder.springBootStarter.Pojo.KiUserTbl;

@Repository
public interface UserInfoRepository extends JpaRepository<KiUserTbl,Long>{
	//public String saveUserDetail(UserModel userModel);
	@Query("from KiUserTbl as kiUser where kiUser.user_username = :user_username")
	public List<KiUserTbl> getUserDetailsByUserName(@Param("user_username") String user_username);
	
	@Query("from KiUserTbl as kiUser where kiUser.user_username = :user_username")
	public KiUserTbl getUserByUsername(@Param("user_username") String user_username);
	
	
	@Query("from KiUserTbl as kiUser where kiUser.user_username = :user_username")
	public KiUserTbl loginUser(@Param("user_username") String user_username);
	
	@Query("from KiUserTbl as kiUser where uniqueCode = :uniqueCode")
	public KiUserTbl getUserByUniqueCode(@Param("uniqueCode") String uniqueCode);
	
}

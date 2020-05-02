package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.GroupParticipantTbl;

public interface GroupParticipantRepository extends JpaRepository<GroupParticipantTbl, Long>{

	@Query("from GroupParticipantTbl as gpt where gpt.userInfoTb.user_id = :user_id")
	public GroupParticipantTbl getByGrpAdminId(@Param("user_id") long user_id);
	
}

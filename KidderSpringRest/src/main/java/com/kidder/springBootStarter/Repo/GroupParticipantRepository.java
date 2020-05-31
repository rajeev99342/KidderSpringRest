package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kidder.springBootStarter.Pojo.KiGroupParticipantTbl;

public interface GroupParticipantRepository extends JpaRepository<KiGroupParticipantTbl, Long>{

	@Query("from KiGroupParticipantTbl as gpt where gpt.userInfoTb.user_id = :user_id")
	public KiGroupParticipantTbl getByGrpAdminId(@Param("user_id") long user_id);

	@Query("from KiGroupParticipantTbl as gpt where gpt.userInfoTb.user_id = :user_id and gpt.groupInfoTbl.grp_id = :grp_id")
	public KiGroupParticipantTbl getParticipantByGrpIdandUserId(@Param("user_id") Long user_id,@Param("grp_id") Long grp_id);

}

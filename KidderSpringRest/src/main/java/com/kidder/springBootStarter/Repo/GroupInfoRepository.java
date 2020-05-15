package com.kidder.springBootStarter.Repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.GroupInfoTbl;

public interface GroupInfoRepository extends JpaRepository<GroupInfoTbl,Long>{
	@Query("from GroupInfoTbl as g where g.grp_name = :grp_name")
	public List<GroupInfoTbl>getGroupDetailsByGroupName(@Param("grp_name") String grp_name);

	
	@Query("from GroupInfoTbl as g where g.grp_id = :grp_id")
	public Set<GroupInfoTbl>getByUserId(@Param("grp_id") Long grp_id);
	
	
	
	@Query("from GroupInfoTbl as g where g.grp_admin = :grp_admin")
	public Set<GroupInfoTbl>getGrpByAdmin(@Param("grp_admin") String grp_admin);
	
	@Query("from GroupInfoTbl")
	public Set<GroupInfoTbl>getAllGrp();
	
	
	@Query("from GroupInfoTbl as g where g.grp_id in (select gp.groupInfoTbl.grp_id from GroupParticipantTbl as gp where gp.userInfoTb.user_id = :user_id) ")
	public Set<GroupInfoTbl>getGrpByUserId(@Param("user_id") long user_id);
	
}

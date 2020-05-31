package com.kidder.springBootStarter.Repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiGroupTbl;

public interface GroupInfoRepository extends JpaRepository<KiGroupTbl,Long>{
	@Query("from KiGroupTbl as g where g.grp_name = :grp_name")
	public List<KiGroupTbl>getGroupDetailsByGroupName(@Param("grp_name") String grp_name);

	
	@Query("from KiGroupTbl as g where g.grp_id = :grp_id")
	public Set<KiGroupTbl>getByUserId(@Param("grp_id") Long grp_id);
	
	
	
	@Query("from KiGroupTbl as g where g.grp_admin = :grp_admin")
	public Set<KiGroupTbl>getGrpByAdmin(@Param("grp_admin") String grp_admin);
	
	@Query("from KiGroupTbl")
	public Set<KiGroupTbl>getAllGrp();
	
	
	@Query("from KiGroupTbl as g where g.grp_id in (select gp.groupInfoTbl.grp_id from KiGroupParticipantTbl as gp where gp.userInfoTb.user_id = :user_id)")
	public Set<KiGroupTbl>getGrpByUserId(@Param("user_id") long user_id);

	
	
	@Query("from KiGroupTbl as g where uniqueCode = uniqueCode")
	public KiGroupTbl getGroupByUniqueCode(@Param("uniqueCode") String uniqueCode);
}

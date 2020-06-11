package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kidder.springBootStarter.Pojo.KiQuizeTbl;
@Repository
public interface QuizeInfoRepository extends JpaRepository<KiQuizeTbl,Long>{
//	@Query("from GroupInfoTbl where grp_name = :grp_name")
//	public List<GroupInfoTbl>getGroupDetailsByGroupName(String grp_name);
	@Query("from KiQuizeTbl as quiz where unique_code = :unique_code and deleteFl = false")
	public KiQuizeTbl getByUniqueCode(@Param("unique_code") String unique_code);
	
	
	@Query("from KiQuizeTbl test where test.grpInfoTbl.grp_id in (select grp_id from KiGroupTbl where deleteFl = false) and deleteFl = false")
	public List<KiQuizeTbl> getAllTestByGrpId(@Param("grp_id") Long grp_id);
	
}

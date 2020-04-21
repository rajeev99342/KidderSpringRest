package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
@Repository
public interface QuizeInfoRepository extends JpaRepository<QuizeInfoTbl,Long>{
//	@Query("from GroupInfoTbl where grp_name = :grp_name")
//	public List<GroupInfoTbl>getGroupDetailsByGroupName(String grp_name);

}

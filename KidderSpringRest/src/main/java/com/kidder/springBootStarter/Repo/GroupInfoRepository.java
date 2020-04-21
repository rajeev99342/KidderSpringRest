package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kidder.springBootStarter.Pojo.GroupInfoTbl;

public interface GroupInfoRepository extends JpaRepository<GroupInfoTbl,Long>{
	@Query("from GroupInfoTbl where grp_name = :grp_name")
	public List<GroupInfoTbl>getGroupDetailsByGroupName(String grp_name);

}

package com.kidder.springBootStarter.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;

public interface TestRoomRepository extends JpaRepository<QuizeInfoTbl, Long>{

	@Query("from QuizeInfoTbl as qt where qt.grpInfoTbl.grp_id = :grp_id")
	List<QuizeInfoTbl> getTestRoomByGroupId(@Param("grp_id") long grp_id);
	
	
	@Query("from QuizeInfoTbl as qt where qt.quiz_id = :quiz_id")
	QuizeInfoTbl getQuizByQuizId(@Param("quiz_id") long quiz_id);
}

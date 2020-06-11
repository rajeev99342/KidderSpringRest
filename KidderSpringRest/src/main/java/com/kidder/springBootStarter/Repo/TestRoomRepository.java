package com.kidder.springBootStarter.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiQuizeTbl;

public interface TestRoomRepository extends JpaRepository<KiQuizeTbl, Long>{

	@Query("from KiQuizeTbl as qt where qt.grpInfoTbl.grp_id = :grp_id")
	List<KiQuizeTbl> getTestRoomByGroupId(@Param("grp_id") long grp_id);
	
	
	@Query("from KiQuizeTbl as qt where qt.quizId = :quizId")
	KiQuizeTbl getQuizByQuizId(@Param("quizId") long quizId);
}

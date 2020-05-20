package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiTxtQuestTbl;

public interface TxtQuestionRepository extends JpaRepository<KiTxtQuestTbl,Long>{

	@Query("from KiTxtQuestTbl as txt where uniqueCode = :uniqueCode")
	public KiTxtQuestTbl getByUniqueCode(@Param("uniqueCode") String uniqueCode);
	
}

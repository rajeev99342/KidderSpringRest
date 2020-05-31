package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiImgTbl;

public interface ImageRepository extends JpaRepository<KiImgTbl, Long>{

	@Query("from KiImgTbl as img where uniqueCode = :uniqueCode ")
	KiImgTbl getImgQuestByUniqueCode(@Param("uniqueCode") String uniqueCode);
	
}

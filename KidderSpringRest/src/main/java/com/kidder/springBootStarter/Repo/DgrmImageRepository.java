package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiDgrmImgTbl;

public interface DgrmImageRepository extends JpaRepository<KiDgrmImgTbl, Long> {
//
	@Query("from KiDgrmImgTbl as dgrm where uniqueCode = :uniqueCode ")
	KiDgrmImgTbl getDgrmByUniqueCode(@Param("uniqueCode") String uniqueCode);
	
	
}

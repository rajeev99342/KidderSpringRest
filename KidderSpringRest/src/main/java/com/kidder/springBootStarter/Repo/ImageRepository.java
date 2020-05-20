package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiImgTbl;

public interface ImageRepository extends JpaRepository<KiImgTbl, Long>{

}

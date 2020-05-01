package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.ImageInfoTbl;

public interface ImageRepository extends JpaRepository<ImageInfoTbl, Long>{

}

package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kidder.springBootStarter.Pojo.ImageInfoTbl;
@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInfoTbl,Long>{

}

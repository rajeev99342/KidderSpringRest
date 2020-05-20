package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiTopicTbl;

public interface KiTopicRepository extends JpaRepository<KiTopicTbl, Long>{

}

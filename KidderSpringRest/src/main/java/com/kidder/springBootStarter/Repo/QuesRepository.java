package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;

public interface QuesRepository extends JpaRepository<UserQuestInfoTbl, Long>{

}

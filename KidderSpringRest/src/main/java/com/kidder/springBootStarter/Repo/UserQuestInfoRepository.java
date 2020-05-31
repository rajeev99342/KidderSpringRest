package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;

public interface UserQuestInfoRepository extends JpaRepository<KiUserQuestTbl,Long>{

}

package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;

public interface QuesRepository extends JpaRepository<KiUserQuestTbl, Long>{

}

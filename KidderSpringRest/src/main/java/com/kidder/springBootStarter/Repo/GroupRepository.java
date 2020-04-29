package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.GroupInfoTbl;

public interface GroupRepository extends JpaRepository<GroupInfoTbl, Long> {

}

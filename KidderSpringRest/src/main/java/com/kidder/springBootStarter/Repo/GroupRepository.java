package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiGroupTbl;

public interface GroupRepository extends JpaRepository<KiGroupTbl, Long> {

}

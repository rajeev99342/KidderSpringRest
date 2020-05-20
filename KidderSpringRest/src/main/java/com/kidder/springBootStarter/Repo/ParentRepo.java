package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.ParentTbl;


public interface ParentRepo extends JpaRepository<ParentTbl, Long> {

}

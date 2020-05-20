package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.ChildTbl;

public interface ChildRepo extends JpaRepository<ChildTbl, Long>{

}

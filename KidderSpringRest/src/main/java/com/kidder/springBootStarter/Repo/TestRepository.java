package com.kidder.springBootStarter.Repo;

import org.springframework.stereotype.Repository;

import com.kidder.springBootStarter.Pojo.TestTbl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

@Repository
public interface TestRepository extends JpaRepository<TestTbl,Long>{

}

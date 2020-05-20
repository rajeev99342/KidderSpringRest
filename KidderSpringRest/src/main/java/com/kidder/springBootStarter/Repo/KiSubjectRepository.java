package com.kidder.springBootStarter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidder.springBootStarter.Pojo.KiSubjectTbl;

public interface KiSubjectRepository  extends JpaRepository<KiSubjectTbl, Long> {

}

package com.kidder.springBootStarter.Repo;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kidder.springBootStarter.Pojo.KiGrpReqstTbl;
@Repository
public interface UserGrpRepository extends JpaRepository<KiGrpReqstTbl,Long>{
//	@Query("update GrpReqstTbl grt set grt.grp_reqst_status = :grp_reqst_status, grt.grp_reqst_lst_modified = :grp_reqst_lst_modified where user_username = :user_username and grp_name in (select grp_name from GroupInfoTbl where grp_admin=:grp_admin)")
//	public void updateReqstStatus(@Param("grp_reqst_status") int grp_reqst_status, @Param("grp_reqst_lst_modified") Timestamp grp_reqst_lst_modified, @Param("user_username") String user_username, @Param("grp_admin") String grp_admin );
//
//	
//	
//	
}

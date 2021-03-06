package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiKidderQuestTbl;

public interface KiKidderQuestRepository extends JpaRepository<KiKidderQuestTbl, Long> {
//
//	@Query("from KiKidderQuestTbl as ki where ki.userInfoTbl.user_username = :user_username and ki.ki_kidder_quest_level = :ki_kidder_quest_level")
//	public List<KiKidderQuestTbl> getKidderQuestByLevel(@Param("user_username") String user_username,@Param("ki_kidder_quest_level") Integer ki_kidder_quest_level);
//	
	@Query("from KiKidderQuestTbl as ki where ki.uniqueCode = :uniqueCode and deleteFl = false")
	public KiKidderQuestTbl getByUniqueCode(@Param("uniqueCode") String uniqueCode);
	
	@Query("from KiKidderQuestTbl as ki where ki.userInfoTbl.user_username = :user_username and deleteFl = false")
	public List<KiKidderQuestTbl> getQuestionByAdmin(@Param("user_username") String user_username);
	
	
	@Query("from KiKidderQuestTbl as ki where ki.quiz_id = :quiz_id and deleteFl = false")
	public List<KiKidderQuestTbl> getQuestionByQuizId(@Param("quiz_id") Long quiz_id);
	
//	@Query("from KiKidderQuestTbl as ki where ki.quiz_id in (select * from ki.) and deleteFl = false")
//	public List<KiKidderQuestTbl> getQuestionByupcomingQuizId(@Param("quiz_id") Long quiz_id);
	
	
}

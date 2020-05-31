package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.KiUserQuestTbl;

public interface QuestionRepository extends JpaRepository<KiUserQuestTbl, Long> {

	@Query("from KiUserQuestTbl as uQues where uQues.quiz_id = :quiz_id")
	List<KiUserQuestTbl> getQuestionByQuizId(@Param("quiz_id") Long quiz_id);
	
}

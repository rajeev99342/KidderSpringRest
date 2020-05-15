package com.kidder.springBootStarter.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidder.springBootStarter.Pojo.UserQuestInfoTbl;

public interface QuestionRepository extends JpaRepository<UserQuestInfoTbl, Long> {

	@Query("from UserQuestInfoTbl as uQues where uQues.quizInfoTbl.quiz_id = :quiz_id")
	List<UserQuestInfoTbl> getQuestionByQuizId(@Param("quiz_id") long quiz_id);
	
}

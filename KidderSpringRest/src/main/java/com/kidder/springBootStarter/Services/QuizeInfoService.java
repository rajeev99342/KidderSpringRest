package com.kidder.springBootStarter.Services;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidder.springBootStarter.Model.QuizModel;
import com.kidder.springBootStarter.Pojo.QuizeInfoTbl;
import com.kidder.springBootStarter.Repo.QuizeInfoRepository;
import com.kidder.springBootStarter.Repo.UserQuestInfoRepository;

@Service
public class QuizeInfoService {
@Autowired
QuizeInfoRepository quizeInfoRepository;

@Autowired
QuizeInfoTbl quizeInfoTbl;
@Autowired
UserQuestInfoRepository userQuestInfoRepository;
@Autowired
UserQuestInfoService userQuestInfoService;

public QuizeInfoTbl saveQuizDetail(QuizModel quizModel) {
	if (quizModel.getQuiz_created_date() == null) {
		long millis=System.currentTimeMillis();  
		quizModel.setQuiz_created_date(new Timestamp(millis));
	}
	SetParams(quizModel);
	quizeInfoTbl = quizeInfoRepository.save(quizeInfoTbl);
	quizModel.setQuiz_id(quizeInfoTbl.getQuiz_id());
	if(quizModel.getUser_questlist().size() !=0) {
		for(int i=0;i<quizModel.getUser_questlist().size();i++) {
			quizModel.getUser_questlist().get(i).setQuiz_id(quizeInfoTbl.getQuiz_id());	
		}
//		if(quizModel.getQuest_ids_list() == null) {
//			quizModel.setQuest_ids_list(new ArrayList<Integer>());
//		}
		userQuestInfoService.batchQuestionInsert(quizModel.getUser_questlist());
	}
	
	return null;
}

public void SetParams(QuizModel quizModel) {
	quizeInfoTbl.setQuiz_id(quizModel.getQuiz_id());
	quizeInfoTbl.setQuiz_created_date(quizModel.getQuiz_created_date());
	quizeInfoTbl.setGrp_name(quizModel.getGrp_name());
	quizeInfoTbl.setQuiz_name(quizModel.getQuiz_name());
//	quizeInfoTbl.setQuiz_exam(quizModel.getQuiz_exam());
	quizeInfoTbl.setQuiz_creator(quizModel.getQuiz_creator());
	quizeInfoTbl.setQuiz_marks(quizModel.getQuiz_marks());
	quizeInfoTbl.setQuiz_duration(quizModel.getQuiz_duration());
	quizeInfoTbl.setQuiz_num_of_ques(quizModel.getQuiz_num_of_ques());
	quizeInfoTbl.setQuiz_published_date(quizModel.getQuiz_published_date());
	
	
}

}

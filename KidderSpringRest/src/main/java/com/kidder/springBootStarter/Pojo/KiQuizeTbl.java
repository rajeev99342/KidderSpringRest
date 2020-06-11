package com.kidder.springBootStarter.Pojo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@javax.persistence.Table(name="ki_quiz_tbl",indexes = 
{@javax.persistence.Index(name="ki_quiz_tbl_pk",columnList = "quiz_id",unique = true)})
public class KiQuizeTbl extends AbstractHibernateObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_id" )
	public long getQuizId() {
		return super.getId();
	}

	public void setQuizId(long quiz_id) {
		super.setId(quiz_id);
	}
	
	private String quizName;
	private int quizNoOfQuest;
	private String quizSub ;
	private Timestamp quizCreatedDate;
	private Timestamp quizPublishedDate;
	private int quizDuration;
	private double quizMarks;
	private KiGroupTbl grpInfoTbl;
	private KiUserTbl userInfoTbl;

	private int quizStatus;
	private Set<KiKidderQuestTbl> kidderQuestTbls;

	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_status" )
	public int getquizStatus() {
		return quizStatus;
	}

	public void setquizStatus(int quizStatus) {
		this.quizStatus = quizStatus;
	}


	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_sub" )

	public String getQuizSub() {
		return quizSub;
	}

	public void setQuizSub(String quizSub) {
		this.quizSub = quizSub;
	}

	


	@javax.persistence.Basic
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="grp_id")
	public KiGroupTbl getGrpInfoTbl() {
		return grpInfoTbl;
	}

	public void setGrpInfoTbl(KiGroupTbl grpInfoTbl) {
		this.grpInfoTbl = grpInfoTbl;
	}
	
	
	@javax.persistence.Basic
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="user_id")

	public KiUserTbl getUserInfoTbl() {
		return userInfoTbl;
	}

	public void setUserInfoTbl(KiUserTbl userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_created_date" )
	public Timestamp getquizCreatedDate() {
		return quizCreatedDate;
	}

	public void setquizCreatedDate(Timestamp quizCreateDate) {
		this.quizCreatedDate = quizCreateDate;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_name" )
	public String getquizName() {
		return quizName;
	}

	public void setquizName(String quizName) {
		this.quizName = quizName;
	}

	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_published_date" )
	public Timestamp getquizPublishedDate() {
		return quizPublishedDate;
	}

	public void setquizPublishedDate(Timestamp quizPublishedDate) {
		this.quizPublishedDate = quizPublishedDate;
	}
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_duration" )
	public int getquizDuration() {
		return quizDuration;
	}

	public void setquizDuration(int quizDuration) {
		this.quizDuration = quizDuration;
	}
	
	
	

	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_marks" )
	public double getquizMarks() {
		return quizMarks;
	}

	public void setquizMarks(double quizMarks) {
		this.quizMarks = quizMarks;
	}
	@javax.persistence.Basic
	@javax.persistence.Column( name = "quiz_num_of_quest" )
	public int getquizNoOfQuest() {
		return quizNoOfQuest;
	}

	public void setquizNoOfQuest(int quizNoOfQuest) {
		this.quizNoOfQuest = quizNoOfQuest;
	}

	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="quiz_id",updatable = false,insertable = false)
	public Set<KiKidderQuestTbl> getKqtbls() {
		return kidderQuestTbls;
	}

	public void setKqtbls(Set<KiKidderQuestTbl> kidderQuestTbls) {
		this.kidderQuestTbls = kidderQuestTbls;
	}

	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "unique_code" )
	public String getUnique_code() {
		return super.getUniqueCode();
	}

	public void setUnique_code(String unique_code) {
		super.setUniqueCode(unique_code);
	}

	@javax.persistence.Basic
	@javax.persistence.Column(name = "deleteFl")

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}


	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}


	
}

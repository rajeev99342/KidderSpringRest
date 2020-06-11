
package com.kidder.springBootStarter.Pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name="ki_kidder_quest_tbl",indexes = 
{@javax.persistence.Index(name="ki_kidder_quest_tbl_pk",columnList = "kq_id",unique = true)})
public class KiKidderQuestTbl extends AbstractHibernateObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String kqName;
	
	private String kqOptionA;
	
	private String kqOptionB;
	
	private String kqOptionC;
	
	private String kqOptionD;
	
	private String kqSub;
	
	private String kqTopic;
	
	private Integer kqLvl;
	
	private String kqAns;
	private long quiz_id;

	private Double kqMarks;
	private KiTxtQuestTbl txtQuesInfoTbl;


	private Set<KiDgrmImgTbl> dgrmImgInfoTbls;
	private KiUserTbl userInfoTbl;

	
	@javax.persistence.Id
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_id")
	@org.hibernate.annotations.Type(type="long")
	@javax.validation.constraints.NotNull
	public Long getkqId() {
		return super.getId();
	}

	public void setkqId(Long ki_kidder_quest_id) {
		super.setId(ki_kidder_quest_id);
	}


	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_topic" )

	public String getkqTopic() {
		return kqTopic;
	}


	public void setkqTopic(String kqTopic) {
		this.kqTopic = kqTopic;
	}
	
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_sub" )
	public void setkqSub(String kqSub) {
		this.kqSub = kqSub;
	}




	public void setkqLvl(Integer kqLvl) {
		this.kqLvl = kqLvl;
	}


	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_lvl" )
	public Integer getkqLvl() {
		return kqLvl;
	}


	public String getkqSub() {
		return kqSub;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_name" )
	public String getkqName() {
		return kqName;
	}


	public void setkqName(String kqName) {
		this.kqName = kqName;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_option_a" )
 
	 
	public String getkqOptionA() {
		return kqOptionA;
	}


	public void setkqOptionA(String kqOptionA) {
		this.kqOptionA = kqOptionA;
	}

	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_option_b" )
  
	public String getkqOptionB() {
		return kqOptionB;
	}


	public void setkqOptionB(String kqOptionB) {
		this.kqOptionB = kqOptionB;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_option_c" )
  
	public String getkqOptionC() {
		return kqOptionC;
	}


	public void setkqOptionC(String kqOptionC) {
		this.kqOptionC = kqOptionC;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_option_d" )
   
	
	public String getkqOptionD() {
		return kqOptionD;
	}


	public void setkqOptionD(String kqOptionD) {
		this.kqOptionD = kqOptionD;
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column( name = "kq_ans" )
	public String getkqAns() {
		return kqAns;
	}


	public void setkqAns(String kqAns) {
		this.kqAns = kqAns;
	}


	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "kq_marks")
  
	public Double getkqMarks() {
		return kqMarks;
	}


	public void setkqMarks(Double kqMarks) {
		this.kqMarks = kqMarks;
	}

	
	
	@javax.persistence.Basic
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="txt_ques_id")

	public KiTxtQuestTbl getTxtQuesInfoTbl() {
		return txtQuesInfoTbl;
	}

	public void setTxtQuesInfoTbl(KiTxtQuestTbl txtQuesInfoTbl) {
		this.txtQuesInfoTbl = txtQuesInfoTbl;
	}
	


	@javax.persistence.Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")

	public KiUserTbl getUserInfoTbl() {
		return userInfoTbl;
	}

	public void setUserInfoTbl(KiUserTbl userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}
	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="kq_id",updatable = false,insertable = false)

	public Set<KiDgrmImgTbl> getDgrmImgInfoTbls() {
		return dgrmImgInfoTbls;
	}


	public void setDgrmImgInfoTbls(Set<KiDgrmImgTbl> dgrmImgInfoTbls) {
		this.dgrmImgInfoTbls = dgrmImgInfoTbls;
	}

	@javax.persistence.Basic
	@javax.persistence.Column(name = "deleteFl")

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}


	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}

	@javax.persistence.Basic
	@javax.persistence.Column(name = "unique_code")
	public String getUniqueCode() {
		return super.getUniqueCode();
	}


	public void setUniqueCode(String uniqueCode) {
		super.setUniqueCode(uniqueCode);
	}

	@javax.persistence.Basic
	@JoinColumn(name = "quiz_id")

	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}
	

}

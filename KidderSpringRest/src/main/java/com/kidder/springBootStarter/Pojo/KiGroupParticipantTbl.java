
package com.kidder.springBootStarter.Pojo;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name="ki_grp_part_tbl",indexes = 
{@javax.persistence.Index(name="ki_grp_part_tbl_pk",columnList = "grp_part_id",unique = true)})
public class KiGroupParticipantTbl extends AbstractHibernateObject{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@javax.persistence.Basic
	@javax.persistence.Column( name = "grp_part_id" )
	public Long getGrp_part_id() {
		return super.getId();
	}

	public void setGrp_part_id(Long grp_part_id) {
		super.setId(grp_part_id);
	}
	
	
	private Boolean isAdmin;
    private KiUserTbl userInfoTb;
    private KiGroupTbl groupInfoTbl;


	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="grp_id")

	public KiGroupTbl getGroupInfoTbl() {
		return groupInfoTbl;
	}

	public void setGroupInfoTbl(KiGroupTbl groupInfoTbl) {
		this.groupInfoTbl = groupInfoTbl;
	}

	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	public KiUserTbl getUserInfoTb() {
		return userInfoTb;
	}

	public void setUserInfoTb(KiUserTbl userInfoTb) {
		this.userInfoTb = userInfoTb;
	}
	

	@javax.persistence.Basic
	@javax.persistence.Column( name = "is_admin" )
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	@javax.persistence.Column( name = "delete_fl" )

	public Boolean getDeleteFl() {
		return super.getDeleteFl();
	}

	public void setDeleteFl(Boolean deleteFl) {
		super.setDeleteFl(deleteFl);
	}

	
}

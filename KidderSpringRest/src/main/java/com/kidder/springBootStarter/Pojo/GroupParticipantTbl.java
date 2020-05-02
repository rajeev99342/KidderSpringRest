
package com.kidder.springBootStarter.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="grp_part_tbl")
public class GroupParticipantTbl {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long grp_part_id;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="grp_id")
    private GroupInfoTbl groupInfoTbl;

	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
    private UserInfoTbl userInfoTb;

	private int isAdmin;





	public Long getGrp_part_id() {
		return grp_part_id;
	}

	public void setGrp_part_id(Long grp_part_id) {
		this.grp_part_id = grp_part_id;
	}

	public GroupInfoTbl getGroupInfoTbl() {
		return groupInfoTbl;
	}

	public void setGroupInfoTbl(GroupInfoTbl groupInfoTbl) {
		this.groupInfoTbl = groupInfoTbl;
	}

	public UserInfoTbl getUserInfoTb() {
		return userInfoTb;
	}

	public void setUserInfoTb(UserInfoTbl userInfoTb) {
		this.userInfoTb = userInfoTb;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	
}

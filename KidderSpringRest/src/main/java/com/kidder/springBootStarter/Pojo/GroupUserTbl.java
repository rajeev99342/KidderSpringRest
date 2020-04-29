//package com.kidder.springBootStarter.Pojo;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="group_user_tbl")
//public class GroupUserTbl {
//
//	
//
//
//
//
//	@javax.persistence.Basic
//	@javax.persistence.Column( name = "grp_name" )
//	private String grp_name;
//	public String getGrp_name() {
//		return grp_name;
//	}
//	public void setGrp_name(String grp_name) {
//		this.grp_name = grp_name;
//	}
//
//
//
//
//	
//	@javax.persistence.Id
//	@javax.persistence.Column( name = "grp_usr_Id" )
//	@org.hibernate.annotations.Type( type = "long" )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long grp_usr_Id;
//	public Long getGrp_usr_Id() {
//		return grp_usr_Id;
//	}
//	public void setGrp_usr_Id(Long grp_usr_Id) {
//		this.grp_usr_Id = grp_usr_Id;
//	}
//	
//	  @OneToMany(mappedBy = "group_user_tbl", cascade = {
//		        CascadeType.ALL
//		    })
//		    private List < UserInfoTbl > userInfoTbl;
//		public List<UserInfoTbl> getUserInfoTbl() {
//			return userInfoTbl;
//		}
//		public void setUserInfoTbl(List<UserInfoTbl> userInfoTbl) {
//			this.userInfoTbl = userInfoTbl;
//		}
//
//
//	
////	@javax.persistence.Basic
////	@OneToMany(targetEntity = UserInfoTbl.class,cascade = CascadeType.ALL)
////	@ElementCollection(targetClass=UserInfoTbl.class)
////	@PrimaryKeyJoinColumn(name = "user_id")
////	private UserInfoTbl userInfoTbl;
////	public void setUserInfoTbl(UserInfoTbl userInfoTbl) {
////		this.userInfoTbl = userInfoTbl;
////	}
////	public UserInfoTbl getUserInfoTbl() {
////		return userInfoTbl;
////	}
//
//
//	@javax.persistence.Basic
//	@javax.persistence.Column( name = "is_grp_admin" )
//	private Boolean is_grp_admin;
//	public Boolean getIs_grp_admin() {
//		return is_grp_admin;
//	}
//	public void setIs_grp_admin(Boolean is_grp_admin) {
//		this.is_grp_admin = is_grp_admin;
//	}
//	
//
//
//
//	
//	
//	
//	
//	
//	
//}

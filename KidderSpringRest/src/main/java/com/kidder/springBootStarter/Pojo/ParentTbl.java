package com.kidder.springBootStarter.Pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="parent_tbl",indexes = 
{@javax.persistence.Index(name="parent_tbl_pk",columnList = "parent_id",unique = true)})
public class ParentTbl extends AbstractHibernateObject{
	
	private static final long serialVersionUID = 1L;

	
	private String parent_name;
	
	private Set<ChildTbl> childs;
	
	@javax.persistence.Id
	@javax.persistence.Column(name="parent_id")
	@org.hibernate.annotations.Type(type="long")
	@javax.validation.constraints.Min( 1 )
	
	public Long getParent_id()
	{
		return super.getId();
	}
	public void setParent_id(Long child_id)
	{
		super.setId(child_id);
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "parent_name")
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	
	@javax.persistence.Basic
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="parent_id",updatable = false,insertable = false)
	public Set<ChildTbl> getChilds() {
		return childs;
	}
	public void setChilds(Set<ChildTbl> childs) {
		this.childs = childs;
	}
	
	
	
	
}

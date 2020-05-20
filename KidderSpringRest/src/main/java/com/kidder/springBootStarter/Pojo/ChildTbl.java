package com.kidder.springBootStarter.Pojo;

import javax.persistence.Entity;

@Entity
@javax.persistence.Table(name="child_tbl",indexes = 
{@javax.persistence.Index(name="child_tbl_pk",columnList = "child_id",unique = true)})
public class ChildTbl extends AbstractHibernateObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String name;
	private long parent_id;
	@javax.persistence.Id
	@javax.persistence.Column(name="child_id")
	@org.hibernate.annotations.Type(type="long")
	@javax.validation.constraints.Min( 1 )
	
	public Long getChild_Id()
	{
		return super.getId();
	}
	public void setChild_Id(Long child_id)
	{
		super.setId(child_id);
	}
	
	@javax.persistence.Basic
	@javax.persistence.Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@javax.persistence.Basic
	@javax.persistence.Column(name = "parent_id")
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	
	
}

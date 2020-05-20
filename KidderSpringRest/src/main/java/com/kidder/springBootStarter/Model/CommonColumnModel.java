package com.kidder.springBootStarter.Model;

public class CommonColumnModel {
	private String uniqueCode;
	private Boolean deleteFl = false;
	private int tenantId = -1;
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public Boolean getDeleteFl() {
		return deleteFl;
	}
	public void setDeleteFl(Boolean deleteFl) {
		this.deleteFl = deleteFl;
	}
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	

}

package com.userauth.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity  
public class Branch {
	
	private static final long serialVersionUID = -5809197156416633600L;
	
	@Id
	@Column(name = "BRANCH_ID", insertable = true, updatable = true, length = 25)
	private String branchId;
	@Column(name = "BRANCH_NAME", insertable = true, updatable = true, length = 50)
	private String branchName;
	@Column(name = "GSTIN", insertable = true, updatable = true, length = 15)
	private String gstin;
	@Column(name = "BRANCH_ADDRESS", insertable = true, updatable = true, length = 200)
	private String branchAddress;

 
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(final String branchName) {
		this.branchName = branchName;
	}

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(final String gstin) {
		this.gstin = gstin;
	}

	public String getBranchAddress() {
		return this.branchAddress;
	}

	public void setBranchAddress(final String branchAddress) {
		this.branchAddress = branchAddress;
	}
}
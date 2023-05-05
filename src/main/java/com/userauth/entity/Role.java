package com.userauth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Role {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ROLE_ID", insertable = true, updatable = false, unique = true, columnDefinition = "VARCHAR(200)")
	private String roleId;
 

	@Column(name = "ROLE_DESCRIPTION", insertable = true, updatable = true)
	private String roleDesc;


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleDesc() {
		return roleDesc;
	}


	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Role(String roleId, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleDesc=" + roleDesc + "]";
	}

 

}

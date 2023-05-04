package com.userauth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "ROLE_NAME", insertable = true, updatable = true, unique = true, columnDefinition = "VARCHAR(200)")
	private String roleName;

	@Column(name = "ROLE_DESCRIPTION", insertable = true, updatable = true)
	private String roleDesc;

//	@JsonIgnore
//	@OneToMany(mappedBy = "roles")
//	private List<User> users;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

 

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}

public Role(Long roleId, String roleName, String roleDesc) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
	this.roleDesc = roleDesc;
}
 

}

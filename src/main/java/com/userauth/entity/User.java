package com.userauth.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 

@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

	private static final long serialVersionUID = -5809197156416633600L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "USERID", insertable = true, updatable = false, length = 25)
	private String userId;

	@Column(name = "USERNAME", insertable = true, updatable = true)
	private String userName;

	@Column(name = "PASSWORD", insertable = true, updatable = true)
	private String password;

	@Column(name = "EMAIL", insertable = true, updatable = true, length = 50)
	private String email;


	@Column(name = "MOBILE", insertable = true, updatable = true)
	private String mobile;

	@Column(name = "PRODUCT_TYPE", insertable = true, updatable = true)
	private String product_type;

	@Column(name = "ORG_ID", insertable = true, updatable = true)
	private String org_id;

	@Column(name = "LOCKED_STATUS", insertable = true, updatable = true)
	private String locked_status;

	@Column(name = "INCORRECT_ATTEMPT", insertable = true, updatable = true)
	private int incorrect_attempt;

	@Column(name = "INCORRECT_MAX_ATTEMPT_LIMIT", insertable = true, updatable = true)
	private int incorrect_max_attempt_limit;

	@Column(name = "FIRST_LOGIN_STATUS", insertable = true, updatable = true)
	private String fisrt_login_status;

	@Column(name = "STATUS", insertable = true, updatable = true)
	private String status;

	@Column(name = "DEPARTMENT", insertable = true, updatable = true)
	private String department;

	@Column(name = "COUNTRY", insertable = true, updatable = true)
	private String country;
	

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name ="users_roles", joinColumns = @JoinColumn (name="userId"), inverseJoinColumns = @JoinColumn (name="roleId"))
//	, cascade = { CascadeType.ALL, CascadeType.MERGE }
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USERID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLEID") })
	private Set<Role> roles = new HashSet<>();

	
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "BRANCH_ID")
	private Branch branch;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getProduct_type() {
		return product_type;
	}


	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}


	public String getOrg_id() {
		return org_id;
	}


	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}


	public String getLocked_status() {
		return locked_status;
	}


	public void setLocked_status(String locked_status) {
		this.locked_status = locked_status;
	}


	public int getIncorrect_attempt() {
		return incorrect_attempt;
	}


	public void setIncorrect_attempt(int incorrect_attempt) {
		this.incorrect_attempt = incorrect_attempt;
	}


	public int getIncorrect_max_attempt_limit() {
		return incorrect_max_attempt_limit;
	}


	public void setIncorrect_max_attempt_limit(int incorrect_max_attempt_limit) {
		this.incorrect_max_attempt_limit = incorrect_max_attempt_limit;
	}


	public String getFisrt_login_status() {
		return fisrt_login_status;
	}


	public void setFisrt_login_status(String fisrt_login_status) {
		this.fisrt_login_status = fisrt_login_status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	 

	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Branch getBranch() {
		return branch;
	}


	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public User(Long id, String userId, String userName, String password, String email, 
			String mobile, String product_type, String org_id, String locked_status, int incorrect_attempt,
			int incorrect_max_attempt_limit, String fisrt_login_status, String status, String department,
			String country,   Set<Role> roles, Branch branch) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	
		this.mobile = mobile;
		this.product_type = product_type;
		this.org_id = org_id;
		this.locked_status = locked_status;
		this.incorrect_attempt = incorrect_attempt;
		this.incorrect_max_attempt_limit = incorrect_max_attempt_limit;
		this.fisrt_login_status = fisrt_login_status;
		this.status = status;
		this.department = department;
		this.country = country;
		 
		this.roles = roles;
		this.branch = branch;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email+ ", mobile=" + mobile + ", product_type="
				+ product_type + ", org_id=" + org_id + ", locked_status=" + locked_status + ", incorrect_attempt="
				+ incorrect_attempt + ", incorrect_max_attempt_limit=" + incorrect_max_attempt_limit
				+ ", fisrt_login_status=" + fisrt_login_status + ", status=" + status + ", department=" + department
				+ ", country=" + country    
				+ ", roles=" + roles + ", branch=" + branch + "]";
	}

	 
	

}

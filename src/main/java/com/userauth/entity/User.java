package com.userauth.entity; 

import java.util.HashSet;
import java.util.Set;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
      

@Entity
@Table(name="USERS")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="USERID", insertable=true,unique = true, length=25)
	private String  userId;
	
	@Column(name="USERNAME", insertable=true, updatable = true)
	private String userName;

	@Column(name="PASSWORD", insertable=true, updatable = true)
	private String password;
	 
	@Column(name="MOBILE", insertable=true, updatable = true)
    private String mobile;
	
	@Column(name="EMAIL", insertable=true, updatable = true, length = 50)
	private String	email;
	
	
	@Column(name="LOCKED_STATUS", insertable=true, updatable = true)
	private String locked_status;
	
	@Column(name="INCORRECT_ATTEMPT", insertable=true, updatable = true)
	private int incorrect_attempt;
		
	@Column(name="INCORRECT_MAX_ATTEMPT_LIMIT", insertable=true, updatable = true)
	private int incorrect_max_attempt_limit;
	
	@Column(name="FIRST_LOGIN_STATUS", insertable=true, updatable = true)
	private String fisrt_login_status;
    
	@Column(name="STATUS", insertable=true, updatable = true)
	private String status;
	
//	@ManyToMany
//	@JoinTable(name="user_role",
//	joinColumns = @JoinColumn(name="userId"),
//	inverseJoinColumns = @JoinColumn(name="roleId"))
//	@ManyToOne(optional = true,fetch = FetchType.EAGER)
//	@JoinColumn(name="roleid")
//	private Role roles;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="users_roles", joinColumns = @JoinColumn (name="userId"), inverseJoinColumns = @JoinColumn (name="roleId"))
	private Set<Role> roles=new HashSet<>();

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

 

	 
 

 
	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

 

	public User(Long id, String userId, String userName, String password, String mobile, String email,
			String locked_status, int incorrect_attempt, int incorrect_max_attempt_limit, String fisrt_login_status,
			String status, Set<Role> roles) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.locked_status = locked_status;
		this.incorrect_attempt = incorrect_attempt;
		this.incorrect_max_attempt_limit = incorrect_max_attempt_limit;
		this.fisrt_login_status = fisrt_login_status;
		this.status = status;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", mobile=" + mobile + ", email=" + email + ", locked_status=" + locked_status
				+ ", incorrect_attempt=" + incorrect_attempt + ", incorrect_max_attempt_limit="
				+ incorrect_max_attempt_limit + ", fisrt_login_status=" + fisrt_login_status + ", status=" + status
				+ ", roles=" + roles + "]";
	}

  
	
}

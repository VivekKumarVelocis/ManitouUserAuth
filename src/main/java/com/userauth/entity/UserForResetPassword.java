package com.userauth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;




/**
 * added by kishan pandey. Users entity are transformed to columns on the database table
 */

public class UserForResetPassword extends BaseEntity{

	private static final long serialVersionUID = 1L;
		

		private String  userId;
	    private String password;
       private String newPassword;
		
		public UserForResetPassword() {
			super();
		}

		public UserForResetPassword(String userId, String password, String newPassword) {
			super();
			this.userId = userId;
			this.password = password;
			this.newPassword = newPassword;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNewPassword() {
			return newPassword;
		}

		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}

		@Override
		public String toString() {
			return "UserForResetPassword [userId=" + userId + ", password=" + password + ", newPassword=" + newPassword
					+ "]";
		}

		
	
	


		
	}

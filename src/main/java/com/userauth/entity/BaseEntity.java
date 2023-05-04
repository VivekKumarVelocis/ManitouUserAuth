package com.userauth.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



/**
 * added by Vivek Kumar. baseEntity entity are transformed to columns on the database table
 */
@MappedSuperclass
//@JsonIgnoreProperties(value= {"createdBy", "updatedBy"})
public class BaseEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;

		
	@CreatedBy
	@Basic
	@Column(name="CREATEDBY", nullable=false, insertable=true, updatable=true)
	private String createdBy;
	
	@CreatedDate
	@Basic
	@Column(name="CREATEDON", nullable=false, insertable=true, updatable=true)
	private Calendar createdOn;
	
	@LastModifiedBy
	@Basic
	@Column(name="UPDATEDBY", nullable=true, insertable=true, updatable=true)
	private String updatedBy;
	
	@LastModifiedDate
	@Basic
	@Column(name="UPDATEDON", nullable=true, insertable=true, updatable=true)
	private Calendar updatedOn;

		
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	 @PrePersist
	    public void prePersist() {
		 
	        String createdByUser = getUsernameOfAuthenticatedUser();
	        this.createdBy = createdByUser;
	        this.createdOn = getCreatedOnData();
	        //this.updatedOn = new Date();
	    }

	    @PreUpdate
	    public void preUpdate() {
	        String modifiedByUser = getUsernameOfAuthenticatedUser();
	        this.updatedBy = modifiedByUser;
	        this.updatedOn = getCreatedOnData();
	    }

	    @Transient
	    private String getUsernameOfAuthenticatedUser() {
	    	Optional<Authentication> _checkAuthenticationObject = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication()); 
	        if(_checkAuthenticationObject.isPresent()) {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        Object principal = authentication.getPrincipal();
	        if (authentication == null || !authentication.isAuthenticated()) {
	            return "ADMIN";
	        }
	       
	        if (principal instanceof UserDetails) {
	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	            return userDetails.getUsername();
	        } else {
	            return "ADMIN";
	        }
	    }else {
	    	return "ADMIN";
	    }

	    }
	    
	    
	    
		private Calendar getCreatedOnData() {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			try {
				cal.setTime(cal.getTime());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cal;
		}

	
		
		
		

}

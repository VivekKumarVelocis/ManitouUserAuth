package com.userauth.entity;

import java.io.Serializable;
import java.util.List;

/*
 * added by Vivek Kumar. jwtResponseForToken  pojo used to send response in json
*/
public class JwtResponseForToken implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private String authToken;
	private String status;
	private String statusCode;
	private String errorMsg;

	public JwtResponseForToken() {
		super();
	}

	public JwtResponseForToken(String authToken, String status, String statusCode, String errorMsg) {
		super();
		this.authToken = authToken;
		this.status = status;
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}

	public JwtResponseForToken(String status, String statusCode, String errorMsg) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JwtResponseForToken [authToken=" + authToken + ", status=" + status + ", statusCode=" + statusCode
				+ ", errorMsg=" + errorMsg + "]";
	}

}
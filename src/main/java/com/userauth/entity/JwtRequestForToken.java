package com.userauth.entity;

import java.io.Serializable;

/*
 * added by kishan pandey. jwtRequestForToken pojo used to send token in json
*/
public class JwtRequestForToken implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String clientId;
	private String secretKey;
	public JwtRequestForToken() {
		super();
	}
	public JwtRequestForToken(String clientId, String secretKey) {
		super();
		this.clientId = clientId;
		this.secretKey = secretKey;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "JwtRequestForToken [clientId=" + clientId + ", secretKey=" + secretKey + "]";
	}
	

	
}
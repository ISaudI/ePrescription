package com.eprescription.aarogya.web.model;

public class Login {
	
	private String au360Id;
	private String password;
	private String role;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAu360Id() {
		return au360Id;
	}
	public void setAu360Id(String au360Id) {
		this.au360Id = au360Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}

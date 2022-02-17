package com.coursesMP.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthorityPK implements Serializable {
	
	protected UserDto username;
	protected String role;
	
	public AuthorityPK() {
		
	}
	

	public AuthorityPK(UserDto username, String role) {
		super();
		this.username = username;
		this.role = role;
	}


	public UserDto getUsername() {
		return username;
	}

	public void setUsername(UserDto username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	
	

}

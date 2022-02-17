package com.coursesMP.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "authorities")
//@IdClass(AuthorityPK.class)
@Table(name="authorities",uniqueConstraints= { @UniqueConstraint (columnNames= {"username","authority"}) })
public class Authority implements Serializable{

	@JsonIgnore
	@Id
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="username")
	private UserDto username;
	
	
	@JsonIgnore
	@Id
	@Column (name="authority")
	private String role;
	
	public Authority() {
		
	}
	

	public Authority(UserDto username, String role) {

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

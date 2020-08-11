package com.freshVotes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = -1998111920712502194L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String authority;
	@ManyToOne()
	private User user;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public void setAutority(String autority) {
		this.authority = autority;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	

}

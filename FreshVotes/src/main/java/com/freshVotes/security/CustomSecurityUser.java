package com.freshVotes.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.freshVotes.domain.Authority;
import com.freshVotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails{
	
	private static final long serialVersionUID = -1353561384541411193L;

	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
		this.setAuthorities(user.getAuthorities());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}
	


	@Override
	public String getPassword() {
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
}

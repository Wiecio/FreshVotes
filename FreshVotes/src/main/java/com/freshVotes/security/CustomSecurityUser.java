package com.freshVotes.security;

//import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

//import com.freshVotes.domain.Authority;
import com.freshVotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails{
	
	private static final long serialVersionUID = -1353561384541411193L;

	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		super.setId(user.getId());
		super.setName(user.getName());
		super.setPassword(user.getPassword());
		super.setUsername(user.getUsername());
		super.setAuthorities(user.getAuthorities());
	}

//	@Override
//	public Set<Authority> getAuthorities() {
//		return super.getAuthorities();
//	}
//	
//
//
//	@Override
//	public String getPassword() {
//		return super.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return super.getUsername();
//	}

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

package com.freshVotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshVotes.dao.UserRepository;
import com.freshVotes.domain.Authority;
import com.freshVotes.domain.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User save(User user){
		Authority authority = new Authority();
		authority.setAutority("ROLE_USER");
		authority.setUser(user);
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.getAuthorities().add(authority);
		
		userRepo.save(user);
		
		return user;
	}
	

}

package com.freshVotes.service;





import org.junit.jupiter.api.Test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


class UserDetailsServiceTest {

	@Test
	public void generate_encryted_password() {
		String rawPassword = "admin";
		String encryptedPassword = new BCryptPasswordEncoder().encode(rawPassword);

		System.out.println(encryptedPassword);
		
		
	}

}

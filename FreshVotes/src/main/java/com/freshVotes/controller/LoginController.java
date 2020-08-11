package com.freshVotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshVotes.domain.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@GetMapping("/register")
	String register(ModelMap model ) {
		model.put("user", new User());
		return "register";
	}
	@PostMapping("/register")
	String registerPost(User user) {
		System.out.println(user);
		return "redirect:/register";
	}
}

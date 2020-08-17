package com.freshVotes.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.freshVotes.domain.User;
import com.freshVotes.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	
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
	String registerPost(User user,ModelMap model) {
		try {
		userService.create(user);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			model.put("exception", ex);
			return "/register";
		}
		
		return "redirect:/login";
	}
	
	
}

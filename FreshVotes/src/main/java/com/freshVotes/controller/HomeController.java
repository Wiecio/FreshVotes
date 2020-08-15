package com.freshVotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshVotes.domain.Product;
import com.freshVotes.domain.User;
import com.freshVotes.service.ProductService;


@Controller
public class HomeController {

	@Autowired ProductService productService;
	
	
	@GetMapping("/")
	public String homeView() {
		return "home";
	}
	
	@GetMapping("/dashboard")
	public String dashboardView(@AuthenticationPrincipal User user, ModelMap model) {
		List<Product> products = productService.findByUser(user);
		model.put("products", products);
	
		return "dashboard";
	}
}

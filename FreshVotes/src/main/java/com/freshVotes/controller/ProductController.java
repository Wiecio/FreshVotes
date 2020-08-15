package com.freshVotes.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.freshVotes.domain.Product;
import com.freshVotes.domain.User;
import com.freshVotes.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/products") 
	String createProduct(@AuthenticationPrincipal User user) {
		
		Product product = productService.createProduct(user);
		
		return "redirect:/products/"+product.getId();
	}
	
	
	@GetMapping("/products/{productId}")
	String getProduct(@PathVariable Long productId,ModelMap model,HttpServletResponse response) throws IOException {
		Product product = new Product();
		try {
		product = productService.findById(productId);
		}catch(Exception ex) {
			System.err.println(ex);
			response.sendError(HttpServletResponse.SC_NOT_FOUND,ex.getMessage());
			
		}
		model.put("product", product);
		System.out.println(product);
		return "product";
	}
	
	@PostMapping("/products/{productId}")
	String updateProduct(@PathVariable Long productId,Product product) {
		
		productService.save(product);
		
		return "redirect:/dashboard";
	}
	
	
		
	
}

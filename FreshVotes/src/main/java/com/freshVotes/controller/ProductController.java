package com.freshVotes.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger log = LoggerFactory.getLogger(ProductController.class);
	
	
	@GetMapping("/p/{productName}")
	String productUserView(@PathVariable String productName,ModelMap model) {
		String decodedProductName;
		try {
			decodedProductName = URLDecoder.decode(productName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.warn("Unable to decode the URL string:	"+productName+" ,redirecting to dashboard instead of the intended product user view page");
			return "redirect:/dashboard";
		}
		model.put("product",productService.findByName(decodedProductName));
		return "productUserView";
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
	
	@GetMapping("/products")
	String getProducts(ModelMap model) {
		model.put("products", productService.findByPublished());	
		return "products";
	}
	
	@PostMapping("/products") 
	String createProduct(@AuthenticationPrincipal User user) {
		
		Product product = productService.createProduct(user);
		
		return "redirect:/products/"+product.getId();
	}
	
	@PostMapping("/products/{productId}")
	String updateProduct(@PathVariable Long productId,Product product) {
		
		productService.save(product);
		
		return "redirect:/dashboard";
	}
	
	
		
	
}

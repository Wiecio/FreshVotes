package com.freshVotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshVotes.service.FeatureService;

import javassist.NotFoundException;

@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {
	@Autowired FeatureService featureService;
	
	@GetMapping("/")
	public String getFeatures(@PathVariable Long productId) {
		
		return "feature";
	}
	
	@PostMapping("/")
	public String createFeature(@PathVariable Long productId) {
		try {
		featureService.createFeature(productId);
		}catch(NotFoundException ex) {
			System.err.println(ex.getMessage());
		}
		
		return "feature";
	}
	
	
	
		
}

package com.freshVotes.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshVotes.domain.Feature;
import com.freshVotes.domain.Product;
import com.freshVotes.service.FeatureService;
import com.freshVotes.service.ProductService;

import javassist.NotFoundException;

@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {
	@Autowired FeatureService featureService;
	@Autowired ProductService productService;
	
	private Logger log = LoggerFactory.getLogger(FeatureController.class);
	
	@GetMapping("/")
	public String getFeatures(@PathVariable Long productId,ModelMap model,HttpServletResponse response) throws IOException {
		try {
			Product product = productService.findById(productId);	
			model.put("features",featureService.findByProduct(product));
		}catch(NotFoundException ex) {
			System.err.println(ex.getMessage());
			response.sendError(HttpServletResponse.SC_NOT_FOUND,ex.getMessage());
		}
		
		return "feature";
	}
	@GetMapping("/{featureId}")
	public String getFeature(@PathVariable Long featureId,ModelMap model,HttpServletResponse response) throws IOException {
		try {
			model.put("feature",featureService.findById(featureId));
		} catch (NotFoundException ex) {
			System.err.println(ex.getMessage());
			response.sendError(HttpServletResponse.SC_NOT_FOUND,ex.getMessage());
		}
		
		return "feature";
	}
	@PostMapping("/{featureId}")
	public String updateFeature(@PathVariable Long featureId, Feature feature) {
		feature = featureService.save(feature);
		String productName = feature.getProduct().getName(); 
		try {
			productName = URLEncoder.encode(productName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.warn("Unable to encode the URL string:	"+productName+" ,redirecting to dashboard instead of the intended product user view page");
			return "redirect:/dashboard";
		}
		
		return "redirect:/p/"+productName;
	}
	
	@PostMapping("/")
	public String createFeature(@PathVariable Long productId,HttpServletResponse response) throws IOException {
		Feature feature = new Feature();
		try {
		feature = featureService.createFeature(productId);
		}catch(NotFoundException ex) {
			System.err.println(ex.getMessage());
			response.sendError(HttpServletResponse.SC_NOT_FOUND,ex.getMessage());

		}
		
		return "redirect:/products/{productId}/features/"+ feature.getId();
	}
	
	
	
		
}

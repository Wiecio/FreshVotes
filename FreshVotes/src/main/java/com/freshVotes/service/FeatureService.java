package com.freshVotes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshVotes.dao.FeatureRepository;
import com.freshVotes.dao.ProductRepository;
import com.freshVotes.domain.Feature;
import com.freshVotes.domain.Product;

import javassist.NotFoundException;

@Service
public class FeatureService {
	@Autowired FeatureRepository featureRepository;
	@Autowired ProductRepository productRepository;
	
	public Feature createFeature(Long productId) throws NotFoundException {
		Feature feature = new Feature();
		Product product;
		Optional<Product> productOpt = productRepository.findById(productId);
		if(productOpt.isPresent()) {
			product = productOpt.get();
			feature.setProduct(product);
			feature.setStatus("pending review");
			product.getFeatures().add(feature);
			feature = featureRepository.save(feature);
			
		}else {
			throw new NotFoundException("Product with id: "+productId+"could not be found");
		}
		
		return feature;
	}
	
}

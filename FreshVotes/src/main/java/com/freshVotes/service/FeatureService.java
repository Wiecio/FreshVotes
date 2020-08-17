package com.freshVotes.service;

import java.util.List;
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
			throw new NotFoundException("Product with id: "+productId+" could not be found");
		}
		
		return feature;
	}
	
	public List<Feature> findByProduct(Product product){
		return featureRepository.findByProduct(product);
	}
	
	public Feature findById(Long featureId) throws NotFoundException {
		Optional<Feature> featureOpt = featureRepository.findById(featureId);
		if(featureOpt.isPresent()) {
			return featureOpt.get();
		}
		else {
			throw new NotFoundException("Feature with id: "+featureId+" could not be found");
		}
	}

	public Feature save(Feature feature) {
		return featureRepository.save(feature);
		
	}
	
}

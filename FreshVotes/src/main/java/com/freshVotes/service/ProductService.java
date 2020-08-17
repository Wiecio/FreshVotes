package com.freshVotes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshVotes.dao.ProductRepository;
import com.freshVotes.dao.UserRepository;
import com.freshVotes.domain.Product;
import com.freshVotes.domain.User;

import javassist.NotFoundException;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	
	public Product createProduct(User user) {
		Product product = new Product();
		product.setName("new product");
		product.setPublished(false);
		product.setUser(user);
		user.getProducts().add(product);
		
		product = productRepository.save(product);
		
		return product;
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product findById(Long id) throws NotFoundException {
		Optional<Product> productOpt = productRepository.findById(id);
		if(!productOpt.isPresent()) {
			throw new NotFoundException("Product with id:"+id+" could not be found");
		}
		
		return productOpt.get();
	}
	
	public Product findByName(String name) {
		Product productOpt = productRepository.findByName(name);
		return productOpt;
	}
	
	public List<Product> findByUser(User user){
		
		return productRepository.findByUser(user);
		
	}

	public List<Product> findByPublished() {
		return productRepository.findByPublished(true);
	}
	
}

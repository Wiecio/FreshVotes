package com.freshVotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freshVotes.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

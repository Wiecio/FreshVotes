package com.freshVotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freshVotes.domain.Product;
import com.freshVotes.domain.User;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByUser(User user);
}

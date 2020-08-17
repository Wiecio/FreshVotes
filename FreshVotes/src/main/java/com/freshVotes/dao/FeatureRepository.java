package com.freshVotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freshVotes.domain.Feature;
import com.freshVotes.domain.Product;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
	List<Feature> findByProduct(Product product);
}

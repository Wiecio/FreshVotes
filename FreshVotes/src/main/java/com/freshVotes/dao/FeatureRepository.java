package com.freshVotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freshVotes.domain.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

}

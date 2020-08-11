package com.freshVotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableJpaRepositories(basePackages="com.freshVotes.dao", entityManagerFactoryRef="emf") 
@SpringBootApplication
public class FreshVotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshVotesApplication.class, args);
	}

	
}

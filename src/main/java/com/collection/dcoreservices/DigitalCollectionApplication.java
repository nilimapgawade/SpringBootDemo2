package com.collection.dcoreservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableJpaRepositories(basePackages = { "com.collection.dcoreservices.repositories" })
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class DigitalCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalCollectionApplication.class, args);
	}

}

package com.ecommerce.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.ecommerce.*")
@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EcommerceApplication.class, args);
		
	}

}

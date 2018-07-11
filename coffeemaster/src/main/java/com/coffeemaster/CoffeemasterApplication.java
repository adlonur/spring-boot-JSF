package com.coffeemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author adil
 *
 */
@SpringBootApplication
public class CoffeemasterApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoffeemasterApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeemasterApplication.class, args);
	}
}

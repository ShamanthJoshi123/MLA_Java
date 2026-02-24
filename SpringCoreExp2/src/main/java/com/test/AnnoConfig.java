package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class AnnoConfig {
	@Bean
	@Primary
	public static Address getAddress() {
		return new Address();
	}
	
	@Bean
	public static Address getAddress1() {
		return new Address();
	}
	@Bean
	public Customer getCustomer() {
		return new Customer();
	}
}

package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ForexExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexExchangeApplication.class, args);
	}

}

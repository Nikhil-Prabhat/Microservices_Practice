package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.cognizant")
@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConversion1Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversion1Application.class, args);
	}

}

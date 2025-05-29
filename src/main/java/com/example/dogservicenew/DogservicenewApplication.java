package com.example.dogservicenew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
@OpenAPI30
@SpringBootApplication
@EnableDiscoveryClient
public class DogservicenewApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogservicenewApplication.class, args);
	}

}

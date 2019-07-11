package com.hackfse.agiveawayapp.inventory_management.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.hackfse.agiveawayapp.inventory_management.dao")
@ComponentScan("com.hackfse.agiveawayapp.inventory_management")
@EntityScan("com.hackfse.agiveawayapp.inventory_management.models")
@EnableDiscoveryClient
public class WebServiceConfig {
	public static void main(String[] args) {
		SpringApplication.run(WebServiceConfig.class, args);
	}
}

package com.hackfse.agiveawayapp.login_register.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.hackfse.agiveawayapp.login_register.dao")
@ComponentScan("com.hackfse.agiveawayapp.login_register")
@EntityScan("com.hackfse.agiveawayapp.login_register.models")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class WebServiceConfig {
	public static void main(String[] args) {
		SpringApplication.run(WebServiceConfig.class, args);
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

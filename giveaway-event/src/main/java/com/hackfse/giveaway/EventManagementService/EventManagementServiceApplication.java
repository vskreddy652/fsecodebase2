package com.hackfse.giveaway.EventManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.hackfse.giveaway"})
@EnableJpaRepositories("com.hackfse.giveaway.dao")
@EntityScan("com.hackfse.giveaway.dto") 
@ComponentScan("com.hackfse.giveaway")
@EnableAspectJAutoProxy
@EnableDiscoveryClient
public class EventManagementServiceApplication {

	public static void main(String[] args) {		
		SpringApplication.run(EventManagementServiceApplication.class, args);
	}

}


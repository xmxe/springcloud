package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Circuit breaker example caller application.
 *
 */
@SpringBootApplication
@EnableFeignClients
public class CircuitBreakerServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerServiceAApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
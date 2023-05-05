package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Circuit breaker example callee application.
 *
 */
@SpringBootApplication
public class CircuitBreakerServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerServiceBApplication.class, args);
	}
}
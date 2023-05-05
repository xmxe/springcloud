package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Circuit breaker example callee application.
 *
 */
@SpringBootApplication
public class CircuitBreakerServiceB2Application {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerServiceB2Application.class, args);
	}
}
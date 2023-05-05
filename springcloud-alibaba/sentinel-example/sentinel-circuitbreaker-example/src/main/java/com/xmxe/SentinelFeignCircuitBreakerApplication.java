package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelFeignCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentinelFeignCircuitBreakerApplication.class, args);
	}

}
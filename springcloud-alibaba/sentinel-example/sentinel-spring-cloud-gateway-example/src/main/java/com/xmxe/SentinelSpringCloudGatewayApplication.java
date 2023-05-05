package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelSpringCloudGatewayApplication {

	public static void main(String[] args) {
		// GatewayCallbackManager.setRequestOriginParser(s -> "123");
		SpringApplication.run(SentinelSpringCloudGatewayApplication.class, args);
	}

}
package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoverySpringCloudConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(NacosDiscoverySpringCloudConfigClientApplication.class, args);
	}
}
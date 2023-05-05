package com.xmxe;

import com.xmxe.model.UserConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserConfig.class)
public class NacosConfig24ExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(NacosConfig24ExampleApplication.class, args);
	}
}
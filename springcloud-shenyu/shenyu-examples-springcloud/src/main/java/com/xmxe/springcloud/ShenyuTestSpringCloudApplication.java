package com.xmxe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ShenyuTestSpringCloudApplication.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ShenyuTestSpringCloudApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(ShenyuTestSpringCloudApplication.class, args);
    }
}
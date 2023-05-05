package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient //适用于其他的注册中心，场景较丰富
@EnableEurekaClient//适用于eureka作为注册中心 场景较单一
@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced//开启负载均衡
	RestTemplate restTemplate(){
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(2500);// 设置超时
		requestFactory.setReadTimeout(2000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}
}


package com.xmxe.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
//value的值指定了在给定的load-balancer client配置下，要发送请求到哪个服务(服务id)
@LoadBalancerClient(value = "provider-service", configuration = CustomLoadBalancerConfiguration.class)

// @LoadBalancerClients({
// 		@LoadBalancerClient(value = "stores", configuration = StoresLoadBalancerClientConfiguration.class),
// 		@LoadBalancerClient(value = "customers", configuration = CustomersLoadBalancerClientConfiguration.class)
// })
public class LoadBalancerConfiguration {

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

	// @Bean
	// public WebClient webClient(){
	// 	return loadBalancedWebClientBuilder().build();
	// }
}
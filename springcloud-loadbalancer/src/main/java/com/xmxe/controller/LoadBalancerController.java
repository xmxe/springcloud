package com.xmxe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class LoadBalancerController {
	// 返回WebClient
	private final WebClient.Builder loadBalancedWebClientBuilder;
	private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public LoadBalancerController(WebClient.Builder webClientBuilder, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		this.loadBalancedWebClientBuilder = webClientBuilder;
		this.lbFunction = lbFunction;
	}

	@RequestMapping("/hi")
	public Mono<String> hi(@RequestParam(value = "name", defaultValue = "Mary") String name) {
		return loadBalancedWebClientBuilder.build().get().uri("http://provider-service/get_feign")
				.retrieve().bodyToMono(String.class)
				.map(greeting -> String.format("%s, %s!", greeting, name));
	}

	@RequestMapping("/hello")
	public Mono<String> hello(@RequestParam(value = "name", defaultValue = "John") String name) {
		return WebClient.builder().filter(lbFunction).build().get().uri("http://provider-service/get_feign")
				.retrieve().bodyToMono(String.class)
				.map(greeting -> String.format("%s, %s!", greeting, name));
	}
}
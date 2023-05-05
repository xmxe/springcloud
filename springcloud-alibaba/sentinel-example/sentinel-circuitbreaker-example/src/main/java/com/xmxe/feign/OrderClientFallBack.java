package com.xmxe.feign;

import org.springframework.stereotype.Component;

@Component
public class OrderClientFallBack implements OrderClient {
	@Override
	public String defaultConfig(boolean ok) {
		return "order fallback";
	}
}
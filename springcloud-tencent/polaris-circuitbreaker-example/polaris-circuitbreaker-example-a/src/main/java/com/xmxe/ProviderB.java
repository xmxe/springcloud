package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Circuit breaker example callee provider.
 *
 */
@FeignClient(name = "polaris-circuitbreaker-example-b", fallback = ProviderBFallback.class)
public interface ProviderB {

	/**
	 * Get info of service B.
	 * @return info of service B
	 */
	@GetMapping("/example/service/b/info")
	String info();

}
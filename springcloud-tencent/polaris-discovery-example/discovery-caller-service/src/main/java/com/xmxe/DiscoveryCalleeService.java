package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Discovery callee feign client.
 *
 */
@FeignClient(value = "DiscoveryCalleeService", fallback = DiscoveryCalleeServiceFallback.class)
public interface DiscoveryCalleeService {

	/**
	 * Get sum of two value.
	 * @param value1 value 1
	 * @param value2 value 2
	 * @return sum
	 */
	@GetMapping("/discovery/service/callee/sum")
	int sum(@RequestParam("value1") int value1, @RequestParam("value2") int value2);

}
package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Metadata callee feign client.
 *
 */
@FeignClient(value = "MetadataCalleeService",
		fallback = MetadataCalleeServiceFallback.class)
public interface MetadataCalleeService {

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@GetMapping("/metadata/service/callee/info")
	Map<String, String> info();

}
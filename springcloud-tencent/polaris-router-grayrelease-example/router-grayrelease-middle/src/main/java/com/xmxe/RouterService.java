package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Router callee feign client.
 *
 */
@FeignClient("gray-release-back")
public interface RouterService {

	@GetMapping("/router/gray/rest")
	String rest();

}
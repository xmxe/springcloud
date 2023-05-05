package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Router callee feign client.
 *
 */
@FeignClient("gray-release-front")
public interface RouterService {

	@GetMapping("/router/gray/rest")
	String restByUser(@RequestHeader("uid") int user);
}
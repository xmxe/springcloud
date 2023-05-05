package com.xmxe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Router callee feign client.
 *
 */
@FeignClient("RouterCalleeService")
public interface RouterCalleeService {

	@PostMapping("/router/service/callee/info")
	String info(@RequestParam("name") String name, @RequestBody User user);

}
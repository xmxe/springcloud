package com.xmxe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Service B Controller.
 *
 */
@RestController
@RequestMapping("/example/service/b")
public class ServiceBController {

	/**
	 * Get service information.
	 * @return service information
	 */
	@GetMapping("/info")
	// @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "failed for call my service")
	public String info() {
		return "hello world ! I'm a service B1";
	}
}
package com.xmxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/router/gray")
public class GatewayController {

	@Autowired
	private Environment environment;

	@Autowired
	private RouterService routerService;

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@GetMapping("/route_rule")
	public String routeRule(@RequestHeader("uid") int userId) {
		String appName = environment.getProperty("spring.application.name");
		String resp = routerService.restByUser(userId);
		return appName + " -> " + resp;
	}

}
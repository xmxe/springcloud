package com.xmxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/router/gray")
public class MiddleController {

	@Autowired
	private Environment environment;

	@Autowired
	private RouterService routerService;

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@GetMapping("/rest")
	public String rest() {
		String env = System.getenv("SCT_METADATA_CONTENT_env");
		String appName = environment.getProperty("spring.application.name");
		String curName = appName + "[" + env + "]";
		String resp = routerService.rest();
		return curName + " -> " + resp;
	}
}
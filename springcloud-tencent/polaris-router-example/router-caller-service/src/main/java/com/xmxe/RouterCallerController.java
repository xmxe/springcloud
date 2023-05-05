package com.xmxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Discovery caller controller.
 *
 */
@RestController
@RequestMapping("/router/service/caller")
public class RouterCallerController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RouterCalleeService routerCalleeService;

	/**
	 * Get info of two value.
	 * @return info
	 */
	@GetMapping("/feign")
	public String feign(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		user.setAge(18);
		return routerCalleeService.info(name, user);
	}

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@GetMapping("/rest")
	public String rest(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		user.setAge(18);
		return restTemplate.postForObject(
				"http://RouterCalleeService/router/service/callee/info?name={name}", user, String.class, name);
	}

	/**
	 * health check.
	 * @return health check info
	 */
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "pk ok";
	}

}
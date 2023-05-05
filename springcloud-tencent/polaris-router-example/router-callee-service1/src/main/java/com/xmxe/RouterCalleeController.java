package com.xmxe;

import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Discovery callee controller.
 *
 */
@RestController
@RequestMapping("/router/service/callee")
public class RouterCalleeController {

	private static Logger LOG = LoggerFactory.getLogger(RouterCalleeController.class);

	@Value("${server.port:0}")
	private int port;

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@PostMapping("/info")
	public String info(String name, @RequestBody User user) {
		LOG.info("Discovery Service Callee [{}] is called.", port);
		return String.format("Discovery Service Callee [%s] is called. user = %s", port, cleanXSS(user));
	}

	private User cleanXSS(User user) {
		User u = new User();
		String name = ESAPI.encoder().encodeForHTML(user.getName());
		u.setName(name);
		u.setAge(user.getAge());
		return u;
	}

}
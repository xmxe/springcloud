package com.xmxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the endpoint for get config.
 *
 */
@RestController
@RefreshScope
public class ConfigController {

	@Value("${timeout:1000}")
	private int timeout;

	@Autowired
	private Person person;

	@Autowired
	private Environment environment;

	@GetMapping("/timeout")
	public int timeout() {
		environment.getProperty("timeout", "1000");
		return timeout;
	}

	@GetMapping("/person")
	public String person() {
		return person.toString();
	}

}
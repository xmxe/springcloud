package com.xmxe.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Example of extended configuration. When a configuration in the shared configuration
 * does not meet the requirements, the extended configuration can be used to override the
 * shared configuration. Priority: Main Configuration > Extended Configuration > Shared
 * Configuration.
 */
@RestController
@RequestMapping("/nacos/extension/config")
@RefreshScope
public class ExtensionConfigExample {
	@Value("${spring.datasource.name:}")
	private String name;

	@Value("${spring.datasource.url:}")
	private String url;

	@Value("${spring.datasource.username:}")
	private String username;

	@Value("${spring.datasource.password:}")
	private String password;

	@Value("${spring.datasource.driverClassName:}")
	private String driverClassName;

	@GetMapping
	public Map<String, String> getConfigInfo() {
		Map<String, String> result = new HashMap<>(4);
		result.put("name", name);
		result.put("url", url);
		result.put("username", username);
		result.put("password", password);
		result.put("driverClassName", driverClassName);
		return result;
	}
}
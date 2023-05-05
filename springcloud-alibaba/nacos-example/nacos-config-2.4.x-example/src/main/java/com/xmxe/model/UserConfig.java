package com.xmxe.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "configdata.user")
public class UserConfig {
	private String name;
	private Integer age;
	private Map<String, Object> map;
	private List<User> users;

	@Data
	public static class User {
		private String name;
		private Integer age;
	}

}
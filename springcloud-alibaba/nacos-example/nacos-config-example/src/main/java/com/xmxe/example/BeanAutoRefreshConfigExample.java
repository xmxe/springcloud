package com.xmxe.example;

import com.xmxe.model.NacosConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic bean refresh example.
 */
@RestController
@RequestMapping("/nacos/bean")
public class BeanAutoRefreshConfigExample {

	@Autowired
	private NacosConfigInfo nacosConfigInfo;

	@GetMapping
	public Map<String, String> getConfigInfo() {
		Map<String, String> result = new HashMap<>();
		result.put("serverAddr", nacosConfigInfo.getServerAddr());
		result.put("prefix", nacosConfigInfo.getPrefix());
		result.put("group", nacosConfigInfo.getGroup());
		result.put("namespace", nacosConfigInfo.getNamespace());
		return result;
	}
}
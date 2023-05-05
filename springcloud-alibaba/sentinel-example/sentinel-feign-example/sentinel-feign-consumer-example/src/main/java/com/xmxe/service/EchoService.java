package com.xmxe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * example feign client
 */
@FeignClient(name = "service-provider")
public interface EchoService {

	/**
	 * 调用服务提供方的输出接口.
	 * @param str 用户输入
	 * @return echo result
	 */
	@GetMapping("/echo/{str}")
	String echo(@PathVariable("str") String str);

}
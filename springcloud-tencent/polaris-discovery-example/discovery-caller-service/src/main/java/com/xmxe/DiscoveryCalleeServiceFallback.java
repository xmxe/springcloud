package com.xmxe;

import org.springframework.stereotype.Component;

/**
 * Discovery callee feign client fallback.
 */
@Component
public class DiscoveryCalleeServiceFallback implements DiscoveryCalleeService {

	@Override
	public int sum(int value1, int value2) {
		return 0;
	}

}
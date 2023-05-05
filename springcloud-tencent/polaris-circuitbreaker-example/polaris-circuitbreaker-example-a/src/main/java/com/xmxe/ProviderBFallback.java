package com.xmxe;

import org.springframework.stereotype.Component;

/**
 * Circuit breaker example callee fallback.
 *
 */
@Component
public class ProviderBFallback implements ProviderB {

	@Override
	public String info() {
		return "trigger the refuse for service b";
	}

}
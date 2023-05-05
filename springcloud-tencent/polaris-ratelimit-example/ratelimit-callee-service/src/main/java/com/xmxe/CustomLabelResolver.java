package com.xmxe;

import com.tencent.cloud.polaris.ratelimit.spi.PolarisRateLimiterLabelServletResolver;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * resolver custom label from request.
 *
 */
@Component
public class CustomLabelResolver implements PolarisRateLimiterLabelServletResolver {

	@Override
	public Map<String, String> resolve(HttpServletRequest request) {
		// rate limit by some request params. such as query params, headers ..

		Map<String, String> labels = new HashMap<>();
		labels.put("user", "zhangsan");

		return labels;
	}

}
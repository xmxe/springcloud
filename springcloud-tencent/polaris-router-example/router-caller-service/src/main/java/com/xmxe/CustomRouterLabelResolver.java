package com.xmxe;

import com.google.gson.Gson;
import com.tencent.cloud.polaris.router.spi.RouterLabelResolver;
import feign.RequestTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Customize the business tag information obtained from the request
 *
 */
@Component
public class CustomRouterLabelResolver implements RouterLabelResolver {
	private final Gson gson = new Gson();

	@Override
	public Map<String, String> resolve(RequestTemplate requestTemplate) {
		Map<String, String> labels = new HashMap<>();

		User user = gson.fromJson(new String(requestTemplate.body()), User.class);

		labels.put("user", user.getName());

		return labels;
	}

	@Override
	public Map<String, String> resolve(HttpRequest request, byte[] body) {
		Map<String, String> labels = new HashMap<>();
		User user = gson.fromJson(new String(body), User.class);

		labels.put("user", user.getName());
		return labels;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
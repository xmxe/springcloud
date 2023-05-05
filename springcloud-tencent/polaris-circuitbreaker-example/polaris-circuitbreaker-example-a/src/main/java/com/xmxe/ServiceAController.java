package com.xmxe;

import org.owasp.esapi.ESAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Circuit breaker example caller controller.
 *
 */
@RestController
@RequestMapping("/example/service/a")
public class ServiceAController {

	@Autowired
	private ProviderB polarisServiceB;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Get info of Service B by Feign.
	 * @return info of Service B
	 */
	@GetMapping("/getBServiceInfo")
	public String getBServiceInfo() {
		return polarisServiceB.info();
	}

	@GetMapping("/getBServiceInfoByRestTemplate")
	public String getBServiceInfoByRestTemplate() {
		return restTemplate.getForObject("http://polaris-circuitbreaker-example-b/example/service/b/info", String.class);
	}

	/**
	 * Get info of Service B by RestTemplate.
	 * @return info of Service B
	 */
	@GetMapping("/testRest")
	public String testRest() {
		ResponseEntity<String> entity = restTemplate.getForEntity(
				"http://polaris-circuitbreaker-example-b/example/service/b/info",
				String.class);
		String response = entity.getBody();
		return cleanXSS(response);
	}

	private String cleanXSS(String str) {
		str = ESAPI.encoder().encodeForHTML(str);
		return str;
	}
}
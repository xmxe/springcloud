package com.xmxe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.TooManyRequests;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Rate limit controller.
 *
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

	private static final Logger LOG = LoggerFactory.getLogger(BusinessController.class);

	private final AtomicInteger index = new AtomicInteger(0);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String appName;

	private AtomicLong lastTimestamp = new AtomicLong(0);

	/**
	 * Get information.
	 * @return information
	 */
	@RequestMapping("/info")
	public String info() {
		return "hello world for ratelimit service " + index.incrementAndGet();
	}

	@GetMapping("/invoke")
	public String invokeInfo() throws InterruptedException {
		StringBuffer builder = new StringBuffer();
		CountDownLatch count = new CountDownLatch(30);
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				try {
					ResponseEntity<String> entity = restTemplate.getForEntity("http://" + appName + "/business/info",
							String.class);
					builder.append(entity.getBody() + "\n");
				}
				catch (RestClientException e) {
					if (e instanceof TooManyRequests) {
						builder.append("TooManyRequests " + index.incrementAndGet() + "\n");
					}
					else {
						throw e;
					}
				}
				count.countDown();
			}).start();
		}
		count.await();
		return builder.toString();
	}

	/**
	 * Get information with unirate.
	 * @return information
	 */
	@GetMapping("/unirate")
	public String unirate() {
		long currentTimestamp = System.currentTimeMillis();
		long lastTime = lastTimestamp.get();
		if (lastTime != 0) {
			LOG.info("Current timestamp:" + currentTimestamp + ", diff from last timestamp:" + (currentTimestamp - lastTime));
		}
		else {
			LOG.info("Current timestamp:" + currentTimestamp);
		}
		lastTimestamp.set(currentTimestamp);
		return "hello world for ratelimit service with diff from last request:" + (currentTimestamp - lastTime) + "ms.";
	}
}
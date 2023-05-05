package com.xmxe;

import com.tencent.cloud.common.metadata.MetadataContext;
import com.tencent.cloud.common.metadata.MetadataContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Metadata callee controller.
 *
 */
@RestController
@RequestMapping("/metadata/service/callee")
public class MetadataCalleeController {

	private static final Logger LOG = LoggerFactory.getLogger(MetadataCalleeController.class);

	@Value("${server.port:0}")
	private int port;

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@GetMapping("/info")
	public Map<String, String> info() {
		LOG.info("Metadata Service Callee [{}] is called.", port);

		// Get Custom Metadata From Context
		MetadataContext context = MetadataContextHolder.get();
		Map<String, String> customMetadataMap = context.getFragmentContext(MetadataContext.FRAGMENT_TRANSITIVE);

		customMetadataMap.forEach((key, value) -> {
			LOG.info("Custom Metadata (Key-Value): {} : {}", key, value);
		});

		return customMetadataMap;
	}

}
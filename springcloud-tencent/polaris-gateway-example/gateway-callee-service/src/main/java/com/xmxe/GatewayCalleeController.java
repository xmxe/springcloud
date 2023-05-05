package com.xmxe;

import com.tencent.cloud.common.constant.MetadataConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static com.tencent.cloud.common.constant.ContextConstant.UTF_8;

/**
 * Gateway callee controller.
 */
@RestController
@RequestMapping("/gateway/example/callee")
public class GatewayCalleeController {

	private static Logger LOG = LoggerFactory.getLogger(GatewayCalleeController.class);

	@Value("${server.port:0}")
	private int port;

	/**
	 * Get information of callee.
	 * @return information of callee
	 */
	@RequestMapping("/info")
	public String info() {
		LOG.info("Gateway Example Callee [{}] is called.", port);
		return String.format("Gateway Example Callee [%s] is called.", port);
	}

	/**
	 * Get metadata in HTTP header.
	 *
	 * @param metadataStr metadata string
	 * @return metadata in HTTP header
	 * @throws UnsupportedEncodingException encoding exception
	 */
	@RequestMapping("/echo")
	public String echoHeader(@RequestHeader(MetadataConstant.HeaderName.CUSTOM_METADATA) String metadataStr)
			throws UnsupportedEncodingException {
		LOG.info(URLDecoder.decode(metadataStr, UTF_8));
		metadataStr = URLDecoder.decode(metadataStr, UTF_8);
		return metadataStr;
	}

}
package com.xmxe;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Metadata callee feign client fallback.
 *
 */
@Component
public class MetadataCalleeServiceFallback implements MetadataCalleeService {

	@Override
	public Map<String, String> info() {
		return Maps.newHashMap();
	}

}
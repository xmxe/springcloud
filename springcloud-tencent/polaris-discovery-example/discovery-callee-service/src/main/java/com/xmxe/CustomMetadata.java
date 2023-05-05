package com.xmxe;

import com.tencent.cloud.common.spi.InstanceMetadataProvider;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * custom metadata for instance.
 *
 */
@Component
public class CustomMetadata implements InstanceMetadataProvider {

	@Override
	public Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<>();
		metadata.put("k1", "v1");
		return metadata;
	}

	@Override
	public String getZone() {
		return "shanghai-zone-1";
	}
}
package com.xmxe;

import com.tencent.cloud.common.spi.InstanceMetadataProvider;

import org.springframework.stereotype.Component;

@Component
public class CustomMetadataProvider implements InstanceMetadataProvider {

	@Override
	public String getRegion() {
		return "huadong";
	}
}
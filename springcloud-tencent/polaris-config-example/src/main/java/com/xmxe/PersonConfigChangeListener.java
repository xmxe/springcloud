package com.xmxe;

import com.tencent.cloud.polaris.config.annotation.PolarisConfigKVFileChangeListener;
import com.tencent.cloud.polaris.config.listener.ConfigChangeEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Custom Config Listener Example .
 */
@Component
public final class PersonConfigChangeListener {

	/**
	 * PolarisConfigKVFileChangeListener Example .
	 * @param event instance of {@link ConfigChangeEvent}
	 */
	@PolarisConfigKVFileChangeListener(interestedKeyPrefixes = "teacher")
	public void onChange(ConfigChangeEvent event) {
		Set<String> changedKeys = event.changedKeys();

		for (String changedKey : changedKeys) {
			System.out.printf("%s = %s \n", changedKey, event.getChange(changedKey));
		}
	}

}
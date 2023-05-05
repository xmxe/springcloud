package com.xmxe.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomLoadBalancerConfiguration {

	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new ServiceInstanceListSupplierImpl("provider-service");
	}

	static class ServiceInstanceListSupplierImpl implements ServiceInstanceListSupplier{
		private final String serviceId;

		ServiceInstanceListSupplierImpl(String serviceId) {
			this.serviceId = serviceId;
		}

		@Override
		public String getServiceId() {
			return serviceId;
		}

		@Override
		public Flux<List<ServiceInstance>> get() {
			return Flux.just(Arrays
					.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8100, false),
							new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8101, false),
							new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 8102, false)));
		}
	}
}
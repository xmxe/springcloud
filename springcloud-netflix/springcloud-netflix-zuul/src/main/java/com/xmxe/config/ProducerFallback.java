package com.xmxe.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class ProducerFallback implements FallbackProvider {
	/**
	 * 指定要处理的服务
	 */
	@Override
	public String getRoute() {
		return "provider-service";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		if (cause != null && cause.getCause() != null) {
			String reason = cause.getCause().getMessage();
			log.info("Excption->{}",reason);
		}
		return fallbackResponse();
	}

	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() {
				return 200;
			}

			@Override
			public String getStatusText() {
				return "OK";
			}

			@Override
			public void close() {

			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("The service is unavailable.".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
package com.xmxe.service;

import com.xmxe.entity.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * 创建一个服务层来写入Kafka
 */
@Service
@Slf4j
public class GreetingsService {
	private final GreetingsStreams greetingsStreams;

	@Autowired
	public GreetingsService(GreetingsStreams greetingsStreams) {
		this.greetingsStreams = greetingsStreams;
	}

	/**
	 * 将Greetings对象写入greetings Kafka主题：
	 */
	public void sendGreeting(final Greetings greetings) {
		log.info("Sending greetings {}", greetings);
		MessageChannel messageChannel = greetingsStreams.outboundGreetings();
		messageChannel.send(MessageBuilder
				.withPayload(greetings)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}
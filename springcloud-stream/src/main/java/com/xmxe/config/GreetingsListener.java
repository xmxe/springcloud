package com.xmxe.config;

import com.xmxe.entity.Greetings;
import com.xmxe.service.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 监听Kafka主题greetings上的消息并将它们记录在控制台上
 */
@Component
@Slf4j
public class GreetingsListener {

	/**
	 * Spring Cloud Stream将监听Kafka主题Greetings上的每个新消息对象greetings
	 */
	@StreamListener(GreetingsStreams.INPUT)
	public void handleGreetings(@Payload Greetings greetings) {
		log.info("Received greetings: {}", greetings);
	}
}
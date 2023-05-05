package com.xmxe.controller;

import com.xmxe.entity.Greetings;
import com.xmxe.service.GreetingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StreamKafkaController {

	private final GreetingsService greetingsService;

	@Autowired
	public StreamKafkaController(GreetingsService greetingsService) {
		this.greetingsService = greetingsService;
	}

	/**
	 * 发送消息
	 */
	@GetMapping("/greetings")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetings(@RequestParam("message") String message) {
		Greetings greetings = Greetings.builder()
				.message(message)
				.timestamp(System.currentTimeMillis())
				.build();
		greetingsService.sendGreeting(greetings);
	}
}
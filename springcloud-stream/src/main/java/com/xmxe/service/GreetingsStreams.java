package com.xmxe.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 为了使我们的应用程序能够与Kafka通信，我们需要定义一个出站流来将消息写入Kafka主题，并使用入站流来读取来自Kafka主题的消息
 * 在运行时，Spring将创建一个基于Java代理的GreetingsStreams接口实现，可以在代码中的任何位置注入Spring Bean来访问我们的两个流。
 */
public interface GreetingsStreams {

	String INPUT = "greetings-in";
	String OUTPUT = "greetings-out";

	/**
	 * 定义要从Kafka读取的入站流
	 * 参数是通道名称 否则以方法名作为通道名称
	 */
	@Input(INPUT)
	SubscribableChannel inboundGreetings();

	/**
	 * 定义要写入Kafka的出站流。
	 */
	@Output(OUTPUT)
	MessageChannel outboundGreetings();

}
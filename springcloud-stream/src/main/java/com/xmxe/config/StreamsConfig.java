package com.xmxe.config;

import com.xmxe.service.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 配置Spring Cloud Stream
 * 将Spring Cloud Stream绑定到GreetingsStreams接口中的流
 */
@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
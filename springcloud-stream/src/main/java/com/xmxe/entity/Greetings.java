package com.xmxe.entity;

import lombok.*;


/**
 * 创建消息对象 代表我们读取的消息对象并写入greetings Kafka主题
 */
@Data
@Builder
public class Greetings {
	private long timestamp;
	private String message;

}
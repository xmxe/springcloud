package com.xmxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableDiscoveryClient //适用于其他的注册中心，场景较丰富
//如果需要输入用户名和密码，用户名是user，密码在控制台using generated security password可以找到，或者使用元注解排除SecurityAutoConfiguration.class
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class StreamKafkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamKafkaApplication.class, args);
	}

}
// https://www.jdon.com/springcloud/spring-cloud-streams-kafka-demo.html
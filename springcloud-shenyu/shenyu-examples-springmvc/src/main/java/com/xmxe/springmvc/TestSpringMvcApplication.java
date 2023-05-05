package com.xmxe.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * TestSpringMvcApplication.
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:context/shenyu.xml"})
public class TestSpringMvcApplication {

    /**
     * Main Entrance.
     *
     * @param args startup arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(TestSpringMvcApplication.class, args);
    }

}
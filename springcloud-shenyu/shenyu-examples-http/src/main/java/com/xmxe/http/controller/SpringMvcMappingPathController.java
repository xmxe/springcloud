package com.xmxe.http.controller;

import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringMvcMappingPathController.
 */
@RestController
@ShenyuSpringMvcClient(desc = "spring annotation register")
public class SpringMvcMappingPathController {

    private static final String HELLO_SUFFIX = "I'm Shenyu-Gateway System. Welcome!";

    /**
     * hello.
     *
     * @return result
     */
    @RequestMapping("hello")
    public String hello() {
        return "hello! " + HELLO_SUFFIX;
    }

    /**
     * hi.
     *
     * @param name name
     * @return result
     */
    @RequestMapping("hi")
    public String hello(final String name) {
        return "hi! " + name + "! " + HELLO_SUFFIX;
    }

    /**
     * hi.
     *
     * @param name name
     * @return result
     */
    @PostMapping("post/hi")
    public String post(final String name) {
        return "[post method result]:hi! " + name + "! " + HELLO_SUFFIX;
    }
}
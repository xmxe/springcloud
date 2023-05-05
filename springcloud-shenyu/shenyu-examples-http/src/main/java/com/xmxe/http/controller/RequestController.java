package com.xmxe.http.controller;

import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * RequestController.
 */
@RestController
@RequestMapping("/request")
@ShenyuSpringMvcClient(path = "/request/**")
public class RequestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestController.class);

    @GetMapping(path = "/header")
    public Mono<String> testRequestHeader(@RequestHeader("header_key1") final String headerKey1,
                                          final ServerHttpRequest serverHttpRequest) {
        LOGGER.info("header_key1:{}, receive headers: {}", headerKey1, serverHttpRequest.getHeaders());
        return successMono(serverHttpRequest.getHeaders());
    }

    @PostMapping(path = "/parameter")
    public Mono<String> testRequestParameter(@RequestParam("parameter_key1") final String parameterKey1,
                                             final ServerHttpRequest serverHttpRequest) {
        LOGGER.info("parameter_key1: {}, receive param: {}", parameterKey1, serverHttpRequest.getQueryParams());
        return successMono(serverHttpRequest.getQueryParams());
    }

    @GetMapping(path = "/cookie")
    public Mono<String> testRequestCookie(@CookieValue("userId") final String userId,
                                          final ServerHttpRequest serverHttpRequest) {
        LOGGER.info("userId:{}, receive Cookies: {}", userId, serverHttpRequest.getCookies());
        return successMono(serverHttpRequest.getCookies());
    }

    private Mono<String> successMono(final Object body) {
        return Mono.just("response success: " + body);
    }
}
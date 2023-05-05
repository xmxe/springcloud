package com.xmxe.springmvc.controller;

import com.xmxe.springmvc.dto.OAuth2DTO;
import com.xmxe.springmvc.dto.OrderDTO;
import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * TestController.
 */
@RestController
@RequestMapping("/order")
@ShenyuSpringMvcClient(path = "/order")
public class OrderController {

    /**
     * Save order dto.
     *
     * @param orderDTO the order dto
     * @return the order dto
     */
    @PostMapping("/save")
    @ShenyuSpringMvcClient(path = "/save", desc = "Save order")
    public OrderDTO save(@RequestBody final OrderDTO orderDTO) {
        orderDTO.setName("hello world save order");
        return orderDTO;
    }

    /**
     * Find by id order dto.
     *
     * @param id the id
     * @return the order dto
     */
    @GetMapping("/findById")
    @ShenyuSpringMvcClient(path = "/findById", desc = "Find by id")
    public OrderDTO findById(@RequestParam("id") final String id) {
        return build(id,"hello world findById");
    }

    /**
     * Gets path variable.
     *
     * @param id   the id
     * @param name the name
     * @return the path variable
     */
    @GetMapping("/path/{id}/{name}")
    @ShenyuSpringMvcClient(path = "/path/**")
    public OrderDTO getPathVariable(@PathVariable("id") final String id, @PathVariable("name") final String name) {
        return build(id,"hello world restful: " + name);
    }

    /**
     * Test rest ful order dto.
     *
     * @param id the id
     * @return the order dto
     */
    @GetMapping("/path/{id}/name")
    @ShenyuSpringMvcClient(path = "/path/**/name")
    public OrderDTO testRestFul(@PathVariable("id") final String id) {
        return build(id,"hello world restful inline " + id);
    }

    @GetMapping("/oauth2/test")
    @ShenyuSpringMvcClient(path = "/oauth2/test")
    public OAuth2DTO testRestFul(final HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        final OAuth2DTO oAuth2DTO = new OAuth2DTO();
        oAuth2DTO.setToken(Objects.isNull(token) ? "no authorization" : token);
        return oAuth2DTO;
    }

    private OrderDTO build(final String id, final String name) {
        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setName(name);
        return orderDTO;
    }

}
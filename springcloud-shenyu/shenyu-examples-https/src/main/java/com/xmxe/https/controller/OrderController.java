package com.xmxe.https.controller;

import com.xmxe.https.dto.OrderDTO;
import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController.
 */
@RestController
@RequestMapping("/order")
@ShenyuSpringMvcClient(path = "/order")
public class OrderController {

    /**
     * Find by id order dto.
     *
     * @param id the id
     * @return the order dto
     */
    @GetMapping("/findById")
    @ShenyuSpringMvcClient(path = "/findById", desc = "Find by id")
    public OrderDTO findById(@RequestParam("id") final String id) {
        OrderDTO dto = new OrderDTO();
        dto.setId(id);
        return dto;
    }
}
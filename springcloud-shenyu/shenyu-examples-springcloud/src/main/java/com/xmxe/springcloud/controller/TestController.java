package com.xmxe.springcloud.controller;

import org.apache.shenyu.client.springcloud.annotation.ShenyuSpringCloudClient;
import com.xmxe.springcloud.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController.
 */
@RestController
@RequestMapping("/test")
@ShenyuSpringCloudClient(path = "/test/**")
public class TestController {


    /**
     * Post string.
     *
     * @param userDTO the user dto
     * @return the string
     */
    @PostMapping("/save")
    public UserDTO post(@RequestBody final UserDTO userDTO) {
        userDTO.setUserName("hello world spring cloud save user");
        return userDTO;
    }

    /**
     * Find by user id user dto.
     *
     * @param userId the user id
     * @return the user dto
     */
    @GetMapping("/findByUserId")
    public UserDTO findByUserId(@RequestParam("userId") final String userId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName("hello world spring cloud findBy user");
        return userDTO;
    }
}
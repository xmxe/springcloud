package com.xmxe.springmvc.controller;

import com.xmxe.springmvc.dto.UserDTO;
import com.xmxe.springmvc.result.ResultBean;
import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * TestController.
 */
@RestController
@RequestMapping("/test")
@ShenyuSpringMvcClient(path = "/test/**")
public class HttpTestController {

    /**
     * Post user dto.
     *
     * @param userDTO the user dto
     * @return the user dto
     */
    @PostMapping("/payment")
    public UserDTO post(@RequestBody final UserDTO userDTO) {
        return userDTO;
    }

    /**
     * Find by user id string.
     *
     * @param userId the user id
     * @return the string
     */
    @GetMapping("/findByUserId")
    public UserDTO findByUserId(@RequestParam("userId") final String userId) {
        return buildUser(userId,"hello world");
    }

    /**
     * Find by page user dto.
     *
     * @param keyword the keyword
     * @param page the page
     * @param pageSize the page size
     * @return the user dto
     */
    @GetMapping("/findByPage")
    public UserDTO findByPage(final String keyword, final Integer page, final Integer pageSize) {
        return buildUser(keyword,"hello world keyword is" + keyword + " page is" + page + " pageSize is" + pageSize);
    }

    /**
     * Gets path variable.
     *
     * @param id the id
     * @param name the name
     * @return the path variable
     */
    @GetMapping("/path/{id}")
    public UserDTO getPathVariable(@PathVariable("id") final String id, @RequestParam("name") final String name) {
        return buildUser(id, name);
    }


    /**
     * Test rest ful string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/path/{id}/name")
    public UserDTO testRestFul(@PathVariable("id") final String id) {
        return buildUser(id,"hello world");
    }


    /**
     * Put path variable and body string.
     *
     * @param id the id
     * @param userDTO the user dto
     * @return the string
     */
    @PutMapping("/putPathBody/{id}")
    public UserDTO putPathVariableAndBody(@PathVariable("id") final String id, @RequestBody final UserDTO userDTO) {
        userDTO.setUserId(id);
        userDTO.setUserName("hello world");
        return userDTO;
    }

    /**
     * the waf pass.
     *
     * @return response. result bean
     */
    @PostMapping("/waf/pass")
    public ResultBean pass() {
        final ResultBean response = new ResultBean();
        response.setCode(200);
        response.setMsg("pass");
        return response;
    }

    /**
     * the waf deny.
     *
     * @return response. result bean
     */
    @PostMapping("/waf/deny")
    public ResultBean deny() {
        final ResultBean response = new ResultBean();
        response.setCode(403);
        response.setMsg("deny");
        return response;
    }

    /**
     * request Pass.
     *
     * @param requestParameter the requestParameter.
     * @return ResultBean result bean
     */
    @GetMapping("/request/parameter/pass")
    public ResultBean requestParameter(@RequestParam("requestParameter") final String requestParameter) {
        final ResultBean response = new ResultBean();
        response.setCode(200);
        response.setMsg("pass");

        final Map<String, Object> param = new HashMap<>();
        param.put("requestParameter", requestParameter);
        response.setData(param);
        return response;
    }

    /**
     * request Pass.
     *
     * @param requestHeader the requestHeader.
     * @return ResultBean result bean
     */
    @GetMapping("/request/header/pass")
    public ResultBean requestHeader(@RequestHeader("requestHeader") final String requestHeader) {
        final ResultBean response = new ResultBean();
        response.setCode(200);
        response.setMsg("pass");

        final Map<String, Object> param = new HashMap<>();
        param.put("requestHeader", requestHeader);
        response.setData(param);
        return response;
    }

    /**
     * request Pass.
     *
     * @param cookie the cookie.
     * @return ResultBean result bean
     */
    @GetMapping("/request/cookie/pass")
    public ResultBean requestCookie(@CookieValue("cookie") final String cookie) {
        final ResultBean response = new ResultBean();
        response.setCode(200);
        response.setMsg("pass");

        final Map<String, Object> param = new HashMap<>();
        param.put("cookie", cookie);
        response.setData(param);
        return response;
    }

    /**
     * post sentinel.
     *
     * @return response. result bean
     */
    @PostMapping("/sentinel/pass")
    public ResultBean sentinelPass() {
        return pass();
    }

    private UserDTO buildUser(final String id, final String name) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setUserId(id);
        userDTO.setUserName(name);
        return userDTO;
    }
}
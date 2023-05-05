package com.xmxe.springcloud.controller;

import org.apache.shenyu.client.springcloud.annotation.ShenyuSpringCloudClient;
import com.xmxe.springcloud.dto.EntityResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AllController.
 */
@RestController
@ShenyuSpringCloudClient
public class AllController {

    /**
     * [class annotation] Do not use shenyu annotation path. used post mapping path.
     *
     * @return result
     */
    @PostMapping("/class/annotation/post")
    public EntityResult postMappingUrl() {
        return new EntityResult(200, "[class annotation] Do not use shenyu annotation path. used post mapping path");
    }

    /**
     * [class annotation] Do not use shenyu annotation path. used post mapping path.
     *
     * @return result
     */
    @GetMapping("/class/annotation/get")
    public EntityResult getMappingUrl() {
        return new EntityResult(200, "[class annotation] Do not use shenyu annotation path. used get mapping path");
    }
}
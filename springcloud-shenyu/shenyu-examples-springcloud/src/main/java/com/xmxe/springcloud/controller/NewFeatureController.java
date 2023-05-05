package com.xmxe.springcloud.controller;

import org.apache.shenyu.client.springcloud.annotation.ShenyuSpringCloudClient;
import com.xmxe.springcloud.dto.EntityResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NewFeatureController.
 */
@RestController
@RequestMapping("new/feature")
public class NewFeatureController {

    /**
     * no support gateway access api.
     *
     * @return result
     */
    @RequestMapping("/gateway/not")
    public EntityResult noSupportGateway() {
        return new EntityResult(200, "no support gateway access");
    }

    /**
     * Do not use shenyu annotation path. used request mapping path.
     *
     * @return result
     */
    @RequestMapping("/requst/mapping/path")
    @ShenyuSpringCloudClient
    public EntityResult requestMappingUrl() {
        return new EntityResult(200, "Do not use shenyu annotation path. used request mapping path");
    }

    /**
     * Do not use shenyu annotation path. used post mapping path.
     *
     * @return result
     */
    @PostMapping("/post/mapping/path")
    @ShenyuSpringCloudClient
    public EntityResult postMappingUrl() {
        return new EntityResult(200, "Do not use shenyu annotation path. used post mapping path");
    }

    /**
     * Do not use shenyu annotation path. used post mapping path.
     *
     * @return result
     */
    @GetMapping("/get/mapping/path")
    @ShenyuSpringCloudClient
    public EntityResult getMappingUrl() {
        return new EntityResult(200, "Do not use shenyu annotation path. used get mapping path");
    }

    /**
     * Do not use shenyu annotation path. used put mapping path.
     *
     * @return result
     */
    @PutMapping("/put/mapping/path")
    @ShenyuSpringCloudClient
    public EntityResult putMappingUrl() {
        return new EntityResult(200, "Do not use shenyu annotation path. used put mapping path");
    }

    /**
     * Do not use shenyu annotation path. used put mapping path.
     *
     * @return result
     */
    @DeleteMapping("/delete/mapping/path")
    @ShenyuSpringCloudClient
    public EntityResult deleteMappingUrl() {
        return new EntityResult(200, "Do not use shenyu annotation path. used delete mapping path");
    }
}
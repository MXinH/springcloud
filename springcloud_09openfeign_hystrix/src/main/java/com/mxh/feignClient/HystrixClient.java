package com.mxh.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX",fallback = HystrixClientFallBack.class) //fallback 这个属性用来指定调用当前服务失败的备选
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam("id") String id);
}

package com.mxh.feignClient;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//自定义的 HystrixClient的默认备选
@Configuration
public class HystrixClientFallBack implements HystrixClient {

    @Override
    public String demo(String id) {
        return "当前服务不可用，请稍后重拾" + id;
    }
}

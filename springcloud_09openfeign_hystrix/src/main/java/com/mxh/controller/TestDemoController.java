package com.mxh.controller;

import com.mxh.feignClient.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDemoController {

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("/test")
    public String test() {
        System.out.println("test ok!!!");
        String demo = hystrixClient.demo("-1");
        System.out.println("demo result :" + demo);
        return "test is ok";
    }
}

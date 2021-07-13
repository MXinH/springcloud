package com.mxh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("order")
    public String demo(){

        logger.info("ORDER DEMO ...");

        return "order demo ok 端口为:"+ port;
    }
}

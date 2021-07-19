package com.mxh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String demo() {
        logger.info("demo ok !!!");

        return "demo ok" + name;
    }
}

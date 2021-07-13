package com.mxh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("/demo")
    //熔断之后的快速响应
    @HystrixCommand(fallbackMethod = "demoFallBack"/*,defaultFallback = "defaultFallback"*/) //代表熔断 之后的处理 fallbackMethod书写快速失败方法名
    public String demo(Integer id){
        logger.info("demo port:{}",port);
        if(id <= 0 ){
            throw new RuntimeException("无效id");
        }
        return "demo ok..";
    }

    //默认备选处理  要求返回值为string 参数为无
    public String defaultFallback(){
        return "网路异常，服务链接失败!!!";
    }

    //自定义备选处理 要求与接口的返回值和参数一致
    public String demoFallBack(Integer id){
        return "当前活动过去火爆,服务已被熔断...";
    }



}
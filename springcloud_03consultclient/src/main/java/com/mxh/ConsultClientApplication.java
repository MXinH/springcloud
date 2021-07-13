package com.mxh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication  //代表 springboot 入口
@EnableDiscoveryClient  // 作用： 通用服务注册客户端注解 代表 consul client zk client nacos client
public class ConsultClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultClientApplication.class,args);
    }
}

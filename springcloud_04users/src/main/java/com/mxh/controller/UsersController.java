package com.mxh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired  //服务注册与发现客户端对象
    private DiscoveryClient discoveryClient;

    @Autowired //负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public String invokeDemo(){

        logger.info("Users demo");

        //1 调用订单服务 服务地址url http://localhost:9999/order 必须get 方式 接收返回值为String 类型
       // RestTemplate restTemplate = new RestTemplate();
      //  String orderResult = restTemplate.getForObject("http://localhost:9999/order",String.class);

        //2.使用ribbon 组件 + RestTemplate 实现负载均衡调用 三种方式 01 DiscoveryClient 02 LoadBalanceClient 03 @LoadBalance
       /* List<ServiceInstance> serviceInstances = discoveryClient.getInstances("ORDERS");
        serviceInstances.forEach(serviceInstance -> {
            logger.info("服务主机:{} 服务端口:{} 服务地址:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        });

        String orderResult = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/order", String.class);
        logger.info("调用订单服务成功:{}",orderResult);
        */

       //3.使用LoadBalanceClient 进行服务调用
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");
        logger.info("服务主机:{} 服务端口:{} 服务地址:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        String orderResult = restTemplate.getForObject(serviceInstance.getUri() + "/order", String.class);*/

        //4.使用注解 @LoadBalanced 注解 作用:可以让对象具有ribbon 负载均衡特性  最常用的方式
        String orderResult = restTemplate.getForObject("http://ORDERS//order", String.class);
        return "调用order 服务成功，结果："+orderResult;
    }
}

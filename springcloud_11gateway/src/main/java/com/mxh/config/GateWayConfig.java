package com.mxh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//使用java代码 进行网关的配置  java配置优先于配置文件
@Configuration
public class GateWayConfig {

    /*@Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("category_route", r -> r.path("/category")
                        .uri("http://localhost:8787"))
                .route("product_route", r -> r.path("/product")
                        .uri("http://localhost:8788"))
                .build();
    }*/
}

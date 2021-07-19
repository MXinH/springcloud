package com.mxh.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//自定义网关全局filte
@Configuration
public class CustomerGlobalFilter implements GlobalFilter, Ordered {


    // exchange 交换 封装了 request  response
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //相当于 filter中的httprequest对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过全局filter处理。。。。。。。");
        Mono<Void> filter = chain.filter(exchange); //放行filter继续向后执行
        System.out.println("响应回来filter处理");
        return filter;
    }

    // order 排序 int 数字 用来指定filter执行顺序 默认顺序 按照自然数数字进行排序 -1在所有filter执行之前执行
    @Override
    public int getOrder() {
        return 0;
    }
}

package com.mxh.controller;

import com.mxh.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;


    @GetMapping("findByCategoryIdAndPage")
    public Map<String,Object> findByCategoryIdAndPage(Integer page, Integer rows, Integer categoryId ){
        logger.info("当前也:{} 每页显示记录书:{} 当前类别id:{}}",page,rows,categoryId);
        Map<String,Object> map = new HashMap<>();
        List<Product> list = new ArrayList<>();
        list.add(new Product("衬衫",1,19.9,new Date()));
        list.add(new Product("裤子",2,29.9,new Date()));
        list.add(new Product("鞋子",3,39.9,new Date()));
        int total = 1000;
        map.put("rows",list);
        map.put("total",total);
        return map;

    }

    //定义一个接口 返回只为list
    @GetMapping("/getProductListByCategoryId")
    public List<Product> getProductListByCategoryId(Integer id){
        logger.info("类别id:{}:",id);
        //根据类别id查找商品列表
        List<Product> list = new ArrayList<>();
        list.add(new Product("衬衫",1,19.9,new Date()));
        list.add(new Product("裤子",2,29.9,new Date()));
        list.add(new Product("鞋子",3,39.9,new Date()));
        return list;
    }

    //定一个接口接受参数id类型参数 ，返回一个给予id查询的对象
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        logger.info("id:{}",id);
        return new Product("巴黎世家",20,11.1,new Date());
    }


    //定一个接受集合类型参数
    @GetMapping("/test5")
    public String test5(@RequestParam List<String> ids) {
        ids.forEach(id -> logger.info("id:{}", id));
        return "test5 ok,当前服务端口号为:" + port;
    }


    //定义一个接受数组类型参数接口
    @GetMapping("/test4")
    public String test4(String[] ids) {
        for (String id : ids) {
            logger.info("id:{}", id);
        }
        return "test4 ok,当前服务端口:" + port;
    }

    //定义一个接受对象类型参数接口 (form表单的方式提交对象 使用注解@SpringQueryMap)
    @PostMapping("/test3")
    public String test3(@SpringQueryMap Product product) {
        logger.info("product:{}", product);
        return "test3 ok,当前服务端口为:" + port;
    }

    //定义一个接受对象类型参数接口 ("application/json"的方式 使用注解@RequestBody)
    @PostMapping("/test2")
    public String test2(@RequestBody Product product) {
        logger.info("product:{}", product);
        return "test2 ok,当前服务端口为:" + port;
    }

    //定义一个接受零散类型参数接口  路径传递参数
    @GetMapping("/test1/{id}/{name}")
    public String test1(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        logger.info("id{} name:{}", id, name);
        return "test1 is ok,当前服务端口为:" + port;
    }

    //定义一个接受零散类型参数接口 queryString
    @GetMapping("/test")
    public String test(String name, Integer age) {
        logger.info("name :{}   age:{}", name, age);
        return "test ok,当前服务端口:" + port;
    }

    @GetMapping("/product")
    public String product() {
        logger.info("进入商品服务....");
        return "product ok, 当前服务的端口" + port;
    }
}

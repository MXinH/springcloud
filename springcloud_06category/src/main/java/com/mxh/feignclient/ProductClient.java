package com.mxh.feignclient;

import com.mxh.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//调用商品服务的接口ds
@FeignClient("PRODUCT") //value :用来书写调用服务的id
public interface ProductClient {


    //声明调用商品服务根据类别id查询分页查询商品信息 以及总条数
    @GetMapping("findByCategoryIdAndPage")
    String findByCategoryIdAndPage(@RequestParam ("page")Integer page,@RequestParam("rows")Integer rows,@RequestParam("categoryId")Integer categoryId );

    //声明根据类别id 查询一组商品信息
    @GetMapping("/getProductListByCategoryId")
    List<Product> getProductListByCategoryId(@RequestParam Integer id);

    //声明根据id查询商品信息接口 返回值为一个对象
    @GetMapping("/getProduct/{id}")
    Product getProduct(@PathVariable("id") Integer id);

    //声明调用商品服务中test5接口 传递一个集合类型
    @GetMapping("/test5")
    String test5(@RequestParam List<String> ids);

    //声明调用商品服务中test4接口 传递一个数组类型 使用@RequestParam注解
    @GetMapping("/test4")
    String test4(@RequestParam("ids") String[] ids);

    //声明调用商品服务中test3接口 传递商品对象(form表单的方式传递对象 使用@SpringQueryMap)
    @PostMapping("/test3")
    String test3(@SpringQueryMap Product product);

    //声明调用商品服务中test2接口 传递商品对象("application/json"的方式 使用注解@RequestBody)
    @PostMapping("/test2")
    String test2(@RequestBody Product product);

    //声明调用商品服务中test1接口 路径传递数据
    @GetMapping("/test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id,@PathVariable("name") String name);

    //声明调用商品服务中test接口传递的name age queryString
    @GetMapping("/test")
    String test(@RequestParam("name") String name,@RequestParam("age") Integer age);

    //调用商品服务
    @GetMapping("/product")
    String product();


}

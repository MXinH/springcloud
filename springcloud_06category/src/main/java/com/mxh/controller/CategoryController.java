package com.mxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.mxh.entity.Product;
import com.mxh.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category() {
        logger.info("category service.....");
        //String product = productClient.product();
        //String product = productClient.test("小明", 13);
        //String product = productClient.test1(21, "张三");
        //String product = productClient.test2(new Product("衣服", 2, 22.2, new Date()));
       // String product = productClient.test3(new Product("衣服", 2, 22.2, new Date()));
        //String product = productClient.test4(new String[]{"21","22","23"});
        /*List<String> ids = new ArrayList<>();
        ids.add("11");
        ids.add("12");
        ids.add("13");
        String product = productClient.test5(ids);*/
        /*Product product = productClient.getProduct(20);
        logger.info("product{}",product);*/
       /* List<Product> productListByCategoryId = productClient.getProductListByCategoryId(1);
        productListByCategoryId.forEach(product -> {
            logger.info("product:{}",product);
        });*/
        String byCategoryIdAndPage = productClient.findByCategoryIdAndPage(1, 5, 1);
        System.out.println(byCategoryIdAndPage);
        logger.info("byCategoryIdAndPage string:{}",byCategoryIdAndPage);
        //自定义json反序列化  对象转为json 序列化  json字符串转为对象
        JSONObject jsonObject = JSONObject.parseObject(byCategoryIdAndPage);
        //logger.info("byCategoryIdAndPage json:{}",jsonObject);
        logger.info("total:{}",jsonObject.get("total"));
        logger.info("rows:{}",jsonObject.get("rows"));
        //二次反序列化 将rows 转为 List<Product>
        List<Product> products = jsonObject.parseArray(jsonObject.get("rows").toString(), Product.class);
        products.forEach(product -> {
            logger.info("product:{}",product);
        });
        return "ok";
    }
}

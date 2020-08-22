package com.shop;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.shop.goods.dao")
public class ShopServiceGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run( ShopServiceGoodsApplication.class);
    }

}

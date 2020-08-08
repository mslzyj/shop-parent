package com.shop.goods;

import com.shop.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.shop.goods.dao"})
public class ShopServiceGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run( ShopServiceGoodsApplication.class);
    }

}

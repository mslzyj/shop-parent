package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @autor zyj
 * @date 2020/8/23 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.shop.auth.dao")
@EnableFeignClients(basePackages = {"com.shop.user.feign"})
public class ShopUserOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopUserOauthApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

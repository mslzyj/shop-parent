package com.shop;

import com.shop.user.config.TokenDecode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @autor zyj
 * @date 2020/8/23 21:45
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.shop.user.dao"})
public class ShopServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run( ShopServiceUserApplication.class);
    }

    @Bean
    public TokenDecode tokenDecode(){
        return new TokenDecode();
    }
}

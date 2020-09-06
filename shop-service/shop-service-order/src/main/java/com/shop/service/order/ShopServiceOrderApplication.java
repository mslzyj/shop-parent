package com.shop.service.order;

import com.shop.entity.FeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @autor zyj
 * @date 2020/9/6 11:17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.shop.goods.feign"})
@MapperScan(basePackages = {"com.shop.order.dao"})
public class ShopServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceOrderApplication.class,args);
    }

    /***
     * 创建拦截器Bean对象
     * @return
     */
    @Bean
    public FeignInterceptor feignInterceptor(){
        return new FeignInterceptor();
    }
}

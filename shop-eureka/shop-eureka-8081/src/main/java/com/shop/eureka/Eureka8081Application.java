package com.shop.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka8081Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka8081Application.class);
    }
}

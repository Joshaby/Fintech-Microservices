package com.johaby.fintech.cartaoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CartaoserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartaoserverApplication.class, args);
    }
}

package com.joshaby.fintech.clienteserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClienteserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteserverApplication.class, args);
	}
}

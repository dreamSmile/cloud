package com.lida.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 杜利达
 * @date: 2020/3/13 16:48
 */
@SpringBootApplication
public class ProductWebApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductWebApp.class, args);
    }
}

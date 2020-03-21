package com.lida.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 杜利达
 * @date: 2020/3/13 16:24
 */
@SpringBootApplication
public class CouponWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CouponWebApp.class, args);
    }

}

package com.lida.cloud;

import com.lida.cloud.utils.IDWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: 杜利达
 * @date: 2020/3/13 14:38
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lida.cloud.mapper")
public class CouponServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApp.class, args);
    }

    /**
     * 数据中心
     */
    @Value("${idWorker.dataCenterId}")
    private long dataCenterId;
    /**
     * 机器标识
     */
    @Value("${idWorker.machineId}")
    private long machineId;
    /**
     * id生成器注入
     *
     * @return .
     */
    @Bean
    public IDWorker getIdWorker() {
        return new IDWorker(dataCenterId, machineId);
    }
}

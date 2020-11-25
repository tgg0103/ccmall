package com.tgg.ccmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tanguogang
 * @create 2020-07-16-21:33
 */
@EnableCaching
@MapperScan("com.tgg.ccmall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.tgg.ccmall.product.feign")
public class CcmallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallProductApplication.class, args);
    }
}

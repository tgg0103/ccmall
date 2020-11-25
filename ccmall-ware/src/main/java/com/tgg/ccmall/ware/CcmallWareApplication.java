package com.tgg.ccmall.ware;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tanguogang
 * @create 2020-07-16-23:22
 */
@EnableRabbit
@SpringBootApplication
@EnableDiscoveryClient //注册Nacos
@EnableFeignClients(basePackages = "com.tgg.ccmall.ware.feign")
public class CcmallWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallWareApplication.class, args);
    }
}

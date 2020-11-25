package com.tgg.ccmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tanguogang
 * @create 2020-07-16-22:40
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CcmallCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallCouponApplication.class, args);
    }
}

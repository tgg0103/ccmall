package com.tgg.ccmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tanguogang
 * @create 2020-07-16-23:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CcmallOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallOrderApplication.class, args);
    }
}

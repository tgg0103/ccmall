package com.tgg.ccmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tanguogang
 * @create 2020-07-16-23:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.tgg.ccmall.member.feign")
public class CcmallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallMemberApplication.class,args);
    }
}

package com.tgg.ccmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tanguogang
 * @create 2020-07-20-22:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CcmallThirdPartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallThirdPartyApplication.class, args);
    }
}

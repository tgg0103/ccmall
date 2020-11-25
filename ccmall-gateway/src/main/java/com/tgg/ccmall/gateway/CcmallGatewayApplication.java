package com.tgg.ccmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tanguogang
 * @create 2020-07-17-14:57
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CcmallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallGatewayApplication.class, args);
    }
}

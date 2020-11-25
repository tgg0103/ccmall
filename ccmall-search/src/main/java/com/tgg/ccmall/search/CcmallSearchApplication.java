package com.tgg.ccmall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tanguogang
 * @create 2020-07-28-10:41
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CcmallSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcmallSearchApplication.class,args);
    }
}

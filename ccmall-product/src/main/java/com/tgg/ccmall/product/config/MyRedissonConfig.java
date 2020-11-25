package com.tgg.ccmall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author tanguogang
 * @create 2020-08-03-16:28
 */
@Configuration
public class MyRedissonConfig {

    /**
     * 所有对Redisson的使用都是通过RedissonClient对象
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException{
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.150.132:6379");
        return Redisson.create(config);
    }
}

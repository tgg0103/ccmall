package com.tgg.ccmall.seckill.scheduled;

import com.tgg.ccmall.seckill.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 秒杀商品定时上架
 * @author tanguogang
 * @create 2020-08-10-14:57
 */
@Slf4j
@Service
public class SeckillSkuScheduled {

    @Autowired
    SeckillService seckillService;

    @Autowired
    RedissonClient redissonClient;

    private final String upload_lock = "seckill:upload:lock";

    @Scheduled(cron = "0 0 3 * * ?")
    public void uploadSeckillSkuLatest3Days(){
        //分布式锁
        RLock lock = redissonClient.getLock(upload_lock);

        lock.lock(10, TimeUnit.SECONDS);
        try {
            seckillService.uploadSeckillSkuLatest3Days();
        }finally {
            lock.unlock();
        }

    }
}

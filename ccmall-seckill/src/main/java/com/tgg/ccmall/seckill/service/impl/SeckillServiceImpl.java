package com.tgg.ccmall.seckill.service.impl;

import com.tgg.ccmall.seckill.feign.CouponFeignService;
import com.tgg.ccmall.seckill.service.SeckillService;
import com.tgg.common.utils.R;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author tanguogang
 * @create 2020-08-10-15:03
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    CouponFeignService couponFeignService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;
    @Override
    public void uploadSeckillSkuLatest3Days() {
        R lates3DaySession = couponFeignService.getLates3DaySession();
        //拿到数据放入redis
    }
}

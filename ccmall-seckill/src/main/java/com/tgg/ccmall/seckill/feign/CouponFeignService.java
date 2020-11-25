package com.tgg.ccmall.seckill.feign;

import com.tgg.ccmall.seckill.feign.fallback.CouponFeignServiceFallBack;
import com.tgg.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tanguogang
 * @create 2020-08-10-15:07
 */
@FeignClient(value = "ccmall-coupon-service",fallback = CouponFeignServiceFallBack.class)
public interface CouponFeignService {
    @GetMapping("/coupon/seckillsession/lates3DaySession")
    R getLates3DaySession();
}

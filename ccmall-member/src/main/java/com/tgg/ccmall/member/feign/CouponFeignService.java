package com.tgg.ccmall.member.feign;

import com.tgg.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tanguogang
 * @create 2020-07-17-9:52
 */
@FeignClient("ccmall-coupon-service")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}

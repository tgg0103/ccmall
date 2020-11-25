package com.tgg.ccmall.seckill.feign.fallback;

import com.tgg.ccmall.seckill.feign.CouponFeignService;
import com.tgg.common.exception.BizCodeEnume;
import com.tgg.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tanguogang
 * @create 2020-08-11-20:43
 */
@Slf4j
@Component
public class CouponFeignServiceFallBack implements CouponFeignService {
    @Override
    public R getLates3DaySession() {
        log.info("熔断方法调用。。。。。。。。。。");
        return R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(),BizCodeEnume.TO_MANY_REQUEST.getMsg());
    }
}

package com.tgg.ccmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tgg.common.utils.PageUtils;
import com.tgg.ccmall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:36:39
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.tgg.ccmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tgg.common.utils.PageUtils;
import com.tgg.ccmall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:47:05
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


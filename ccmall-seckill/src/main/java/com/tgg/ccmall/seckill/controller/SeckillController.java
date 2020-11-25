package com.tgg.ccmall.seckill.controller;

import com.tgg.ccmall.seckill.service.SeckillService;
import com.tgg.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tanguogang
 * @create 2020-08-11-17:26
 */
@Controller
public class SeckillController {

    @Autowired
    SeckillService seckillService;
    @ResponseBody
    @GetMapping("/testSentinel")
    public R testSentinel(){
        seckillService.uploadSeckillSkuLatest3Days();
        return R.ok();
    }
}

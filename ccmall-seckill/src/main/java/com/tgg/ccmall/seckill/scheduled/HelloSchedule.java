package com.tgg.ccmall.seckill.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *      1.@EnableScheduling 开启定时任务
 *      2.@Scheduled 开启一个定时任务
 *      3.自动配置类 TaskSchedulingAutoConfiguration
 *
 * 异步任务
 *      1.@EnableAsync 开启异步任务功能
 *      2.@Async 给希望异步执行的方法上标注
 *      3.自动配置类 TaskExecutionAutoConfiguration
 * @author tanguogang
 * @create 2020-08-10-14:34
 */
@Slf4j
@Component
/*@EnableAsync
@EnableScheduling*/
public class HelloSchedule {

    /**
     * 1.spring中6位组成，不允许第7位年
     * 2.在周几的位置
     */
    @Async
    //@Scheduled(cron = "* * * * * ?")
    public void hello(){
        log.info("hello.......");
    }
}

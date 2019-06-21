package com.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count=0;

    /**
     * 每隔六秒钟执行一次
     */
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("SchedulerTask runing  "+(count++));
    }
}

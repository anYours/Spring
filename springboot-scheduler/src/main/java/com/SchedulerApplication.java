package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EnableScheduling表示开启定时任务
 */
@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class);
    }
}

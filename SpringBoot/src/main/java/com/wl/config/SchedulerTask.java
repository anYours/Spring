package com.wl.config;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Deprecated
public class SchedulerTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}

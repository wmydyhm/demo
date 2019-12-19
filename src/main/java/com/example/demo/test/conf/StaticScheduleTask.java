package com.example.demo.test.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration // 标记配置类
@EnableScheduling // 开启定时任务
public class StaticScheduleTask {
    @Scheduled(cron = "0/5 * * * * ?")
    //@Scheduled(fixedRate=5000)
    private void configTasks(){
        //System.err.println("@Scheduled执行静态定时任务时间: " + LocalDate.now());
    }
}

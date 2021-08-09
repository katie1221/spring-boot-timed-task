package com.example.scheduleddemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * @author qzz
 */
@Configuration
public class ScheduleTask {

    /**
     * 添加定时任务：每隔5秒执行一次   cron
     */
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTask(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("执行静态定时任务时间："+df.format(new Date()));
    }


    /**
     * 添加定时任务：每秒执行一次，休眠8秒   fixedRate
     */
    @Scheduled(fixedRate = 1000)
    private void fixedRate() throws Exception {
        System.out.println("fixedRate开始执行时间："+new Date(System.currentTimeMillis()));
        //休眠8秒
        Thread.sleep(1000*8);
        System.out.println("fixedRate执行结束时间："+new Date(System.currentTimeMillis()));
    }

    /**
     * 添加定时任务：fixedDelay表示上一次执行结束后再一次执行的时间
     */
    @Scheduled(fixedDelay = 1000)
    private void fixedDelay() throws Exception {
        System.out.println("fixedDelay开始执行时间："+new Date(System.currentTimeMillis()));
        //休眠2秒
        Thread.sleep(1000*2);
        System.out.println("fixedDelay执行结束时间："+new Date(System.currentTimeMillis()));
    }

    /**
     * 添加定时任务：initialDelay表示项目启动后延迟多久执行定时任务，所以他要配合fixedRate或fixedDelay一起使用
     */
    @Scheduled(initialDelay = 1000*3,fixedDelay = 1000)
    private void fixedDelay2() throws Exception {
        System.out.println("initialDelay开始执行时间："+new Date(System.currentTimeMillis()));
    }

}

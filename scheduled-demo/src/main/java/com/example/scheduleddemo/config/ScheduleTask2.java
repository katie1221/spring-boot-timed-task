package com.example.scheduleddemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务:单线程任务阻塞测试代码
 * @author qzz
 */
@Configuration
public class ScheduleTask2 {

    /**
     * SpringBoot使用@scheduled定时执行任务的时候是在一个单线程中，如果有多个任务，其中一个任务执行时间过长，则有可能会导致其他后续任务被阻塞直到该任务执行完成。
     * 也就是会造成一些任务无法定时执行的错觉
     */

    /**
     * 添加定时任务：每隔1秒执行一次   cron
     */
//    @Scheduled(cron = "0/1 * * * * ?")
//    private void deleteFile() throws Exception {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("111 delete success,time："+df.format(new Date()));
//        //模拟长时间执行，比如IO操作，http请求
//        Thread.sleep(1000*5);
//    }

    /**
     * 添加定时任务：每隔1秒执行一次   cron
     */
//    @Scheduled(cron = "0/1 * * * * ?")
//    private void syncFile() throws Exception {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("222 sync success,time："+df.format(new Date()));
//    }
}

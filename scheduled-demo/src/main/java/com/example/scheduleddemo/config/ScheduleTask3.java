package com.example.scheduleddemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 单线程任务阻塞的解决方法：
 *    （1）使用 @Async 注解采用异步执行方式 ，定时任务实例上添加@Async和@Scheduled注解， 启动类添加@EnableScheduling开启定时任务，添加@EnableAsync开启异步支持
 * @author qzz
 */
@Configuration
public class ScheduleTask3 {

    /**
     * 添加定时任务：每隔1秒执行一次   cron
     */
    @Async
    @Scheduled(cron = "0/1 * * * * ?")
    public void deleteFile() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("第一个定时任务开始："+df.format(new Date()));
        //模拟长时间执行，比如IO操作，http请求
        Thread.sleep(1000*3);
        System.out.println("第一个定时任务结束：" + df.format(new Date()));
    }

    /**
     * 添加定时任务：每隔1秒执行一次   cron
     */
    @Async
    @Scheduled(cron = "0/1 * * * * ?")
    public void syncFile() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("第二个定时任务开始："+df.format(new Date()));
        //模拟长时间执行，比如IO操作，http请求
        Thread.sleep(1000*3);
        System.out.println("第二个定时任务结束：" + df.format(new Date()));
    }

    /**
     * 添加定时任务：每隔1秒执行一次   cron    @Async使用自定义线程池
     */
    @Async("myThreadPool")
    @Scheduled(cron = "0/1 * * * * ?")
    public void test() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("第三个定时任务开始："+df.format(new Date()));
        //模拟长时间执行，比如IO操作，http请求
        Thread.sleep(1000*3);
        System.out.println("第三个定时任务结束：" + df.format(new Date()));
    }
}

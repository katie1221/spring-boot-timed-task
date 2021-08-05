package com.example.quartzdemo.config;

import com.example.quartzdemo.job.SyncUserJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz定时任务配置类
 * @author qzz
 */
@Configuration
public class QuartzConfig {


    /**
     * JobDetail实例
     */
    private static String JOB_GROUP_NAME = "JOB_GROUP_NAME";
    /**
     * 触发器
     */
    private static String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME";

    /**
     * 定时任务1：
     * 同步用户信息（任务详情）
     * @return
     */
    @Bean
    public JobDetail syncUserJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(SyncUserJob.class)
                .withIdentity("syncUserJobDetail",JOB_GROUP_NAME)
                .usingJobData("userName","张三")
                .usingJobData("blogUrl","https://blog.csdn.net/qq_26383975/")
                .usingJobData("blogRemark","您好！欢迎访问qq_26383975的博客")
                //即使没有Trigger关联时，也不需要删除该JobDetail
                .storeDurably()
                .build();
        return  jobDetail;
    }

    /**
     * 定时任务1：
     * 同步用户信息（触发器）
     * @return
     */
    @Bean
    public Trigger syncUserJobTrigger(){

        //每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        //创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                //关联上述的JobDetail
                .forJob(syncUserJobDetail())
                //给Trigger起个名字
                .withIdentity("syncUserJobTrigger",TRIGGER_GROUP_NAME)
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;
    }
}

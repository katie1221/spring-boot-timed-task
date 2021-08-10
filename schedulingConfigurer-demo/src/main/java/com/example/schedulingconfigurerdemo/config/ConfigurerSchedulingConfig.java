package com.example.schedulingconfigurerdemo.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.schedulingconfigurerdemo.dao.CronMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import java.util.Date;

/**
 * 基于接口SchedulingConfigurer的定时任务
 * 注解EnableScheduling：用于开启定时任务
 * @author qzz
 */
@Configuration
@EnableScheduling
public class ConfigurerSchedulingConfig implements SchedulingConfigurer {

    @Autowired
    private CronMapper cronMapper;


    /**
     * 重写配置定时任务的方法
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                ()->{System.out.println("执行动态定时任务："+new Date(System.currentTimeMillis())); }
                //2.设置执行周期(Trigger)
                ,triggerContext -> {
                    //2.1从数据库中获取执行周期
                    String cron = cronMapper.selectOne(null).getCron();
                    //System.out.println("数据库中获取的执行周期是："+cron);
                    //2.2 合法性校验
                    if(StringUtils.isBlank(cron)){
                        //为空，设置默认值
                        cron = "0/5 * * * * ?";
                    }
                    //返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }

        );

    }


}

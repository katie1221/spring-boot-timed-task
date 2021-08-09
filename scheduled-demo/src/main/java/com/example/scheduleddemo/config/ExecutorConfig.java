package com.example.scheduleddemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池
 * @author qzz
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean(name = "myThreadPool")
    public Executor myThreadPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //表示线程池核心线程，正常情况下开启的线程数量
        executor.setCorePoolSize(30);
        //配置队列大小
        executor.setQueueCapacity(500);
        //当核心线程都在跑任务，还有多余的任务会存在此处
        executor.setMaxPoolSize(50);
        //非核心线程的超时时长，超长后会被回收
        executor.setKeepAliveSeconds(60);
        //配置线程池前缀
        executor.setThreadNamePrefix("MyThreadPool-");
        //用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //配置线程池拒绝策略
        executor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor exe)->{
            logger.warn("MyThreadPool-当前任务线程池队列已满");
        });
        //初始化线程池
        executor.initialize();

        return executor;
    }
}

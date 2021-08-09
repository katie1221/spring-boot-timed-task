package com.example.scheduleddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author qzz
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScheduledDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledDemoApplication.class, args);
    }

}

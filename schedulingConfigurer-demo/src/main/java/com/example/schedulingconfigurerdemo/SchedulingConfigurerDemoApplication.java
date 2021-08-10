package com.example.schedulingconfigurerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qzz
 */
@SpringBootApplication
@MapperScan("com.example.schedulingconfigurerdemo.dao")
public class SchedulingConfigurerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingConfigurerDemoApplication.class, args);
    }

}

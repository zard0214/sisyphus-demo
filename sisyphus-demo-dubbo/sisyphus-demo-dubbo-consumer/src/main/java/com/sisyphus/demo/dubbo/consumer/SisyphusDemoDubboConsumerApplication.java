package com.sisyphus.demo.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class SisyphusDemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SisyphusDemoDubboConsumerApplication.class, args);
    }

}

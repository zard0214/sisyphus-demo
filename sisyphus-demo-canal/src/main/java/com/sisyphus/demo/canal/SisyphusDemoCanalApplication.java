package com.sisyphus.demo.canal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SisyphusDemoCanalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SisyphusDemoCanalApplication.class, args);
    }

}

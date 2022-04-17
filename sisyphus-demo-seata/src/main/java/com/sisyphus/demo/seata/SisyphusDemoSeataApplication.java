package com.sisyphus.demo.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        scanBasePackages = {
                "com.sisyphus.demo.seata",
        },
        exclude = {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                MybatisAutoConfiguration.class})
/**
 * use this annotation to scan the Data Access Object for mybatis
 */
@MapperScan(basePackages = {
        "com.sisyphus.demo.seata.common",
        "com.sisyphus.demo.seata.config",
        "com.sisyphus.demo.seata.domain",
        "com.sisyphus.demo.seata.mapper",
        "com.sisyphus.demo.seata.service",
        "com.sisyphus.demo.seata.service.impl",
})
/**
 * enable transaction
 */
@EnableTransactionManagement
public class SisyphusDemoSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SisyphusDemoSeataApplication.class, args);
    }

}

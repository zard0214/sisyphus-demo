package com.sisyphus.demo.data.jpa.config;

import com.xiaoleilu.hutool.lang.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zard
 * @date Created in 09/06/2022 04:08
 */
@Configuration
public class SnowflakeConfig {

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(1 ,1 );
    }
}
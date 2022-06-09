package com.sisyphus.demo.data.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author zard
 * @date Created in 09/06/2022 04:06
 */
public class SecondaryDataSourceConfig {

    /**
     * 扫描spring.datasource.primary开头的配置信息
     *
     * @return 数据源配置信息
     */
    @Primary
    @Bean(name = "secondaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 获取主库数据源对象
     *
     * @param dataSourceProperties 注入名为primaryDataSourceProperties的bean
     * @return 数据源对象
     */
    @Primary
    @Bean(name = "secondaryDataSource")
    public DataSource dataSource(@Qualifier("secondaryDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * 该方法仅在需要使用JdbcTemplate对象时选用
     *
     * @param dataSource 注入名为primaryDataSource的bean
     * @return 数据源JdbcTemplate对象
     */
    @Primary
    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
package com.sisyphus.demo.data.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author zard
 * @date Created in 09/06/2022 04:07
 */
public class SecondaryJpaConfig {

    static final String REPOSITORY_PACKAGE = "com.xkcoding.multi.datasource.jpa.repository.primary";
    private static final String ENTITY_PACKAGE = "com.xkcoding.multi.datasource.jpa.entity.primary";


    /**
     * 扫描spring.jpa.primary开头的配置信息
     *
     * @return jpa配置信息
     */
    @Primary
    @Bean(name = "secondaryJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.secondary")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    /**
     * 获取主库实体管理工厂对象
     *
     * @param primaryDataSource 注入名为primaryDataSource的数据源
     * @param jpaProperties     注入名为primaryJpaProperties的jpa配置信息
     * @param builder           注入EntityManagerFactoryBuilder
     * @return 实体管理工厂对象
     */
    @Primary
    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("secondaryDataSource") DataSource primaryDataSource, @Qualifier("secondaryJpaProperties") JpaProperties jpaProperties, EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(primaryDataSource)
                // 设置jpa配置
                .properties(jpaProperties.getProperties())
                // 设置实体包名
                .packages(ENTITY_PACKAGE)
                // 设置持久化单元名，用于@PersistenceContext注解获取EntityManager时指定数据源
                .persistenceUnit("secondaryPersistenceUnit").build();
    }

    /**
     * 获取实体管理对象
     *
     * @param factory 注入名为primaryEntityManagerFactory的bean
     * @return 实体管理对象
     */
    @Primary
    @Bean(name = "primaryEntityManager")
    public EntityManager entityManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    /**
     * 获取主库事务管理对象
     *
     * @param factory 注入名为primaryEntityManagerFactory的bean
     * @return 事务管理对象
     */
    @Primary
    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}

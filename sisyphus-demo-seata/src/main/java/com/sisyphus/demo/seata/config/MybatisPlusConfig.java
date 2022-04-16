package com.sisyphus.demo.seata.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * it is a config about mybatisplus add some inerceptor to the mybatisplus
 * @author zhecheng.zhao
 * @date Created in 12/06/2021 11:51
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.sisyphus.demo.seata.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //optimism lock: use version to change the data currently.
        //it is different with pessimism lock
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //prevent all table update or delete
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        //add the pagination intercepetor
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}

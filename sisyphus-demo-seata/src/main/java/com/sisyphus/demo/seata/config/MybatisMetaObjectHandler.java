package com.sisyphus.demo.seata.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * auto fill fields
 * @author zhecheng.zhao
 * @date Created in 12/06/2021 11:59
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {


    /**
     * insert gmtCreated field automatic
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //use current date fill the gmtcreated field
        this.strictInsertFill(metaObject, "gmtCreated", () -> LocalDateTime.now(), LocalDateTime.class);
    }

    /**
     * insert gmtModified field auto
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //use current date fill the gmtmodified field
        this.strictUpdateFill(metaObject, "gmtModified", () -> LocalDateTime.now(), LocalDateTime.class);
    }
}

package com.sisyphus.demo.canal.handler;

/**
 * @author zard
 * @date Created in 14/04/2022 09:00
 */
public interface CanalEntryHandler<T> {

    /**
     * 新增
     *
     * @param t 新增数据
     */
    void insert(T t);


    /**
     * 修改
     *
     * @param before 修改前数据
     * @param after  修改后数据
     */
    void update(T before, T after);


    /**
     * 删除
     *
     * @param t 删除数据
     */
    void delete(T t);
}
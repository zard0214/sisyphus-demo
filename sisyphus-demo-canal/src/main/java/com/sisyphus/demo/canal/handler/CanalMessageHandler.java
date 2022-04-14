package com.sisyphus.demo.canal.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sisyphus.demo.canal.util.FieldUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zard
 * @date Created in 14/04/2022 09:00
 */
public class CanalMessageHandler {

    /**
     * key:table名称，value：EntryHandler实现类
     */
    private Map<String, CanalEntryHandler> tableHandlerMap;

    public CanalMessageHandler(List<? extends CanalEntryHandler> entryHandlers) {
        this.tableHandlerMap = this.getTableHandler(entryHandlers);
    }


    public CanalEntryHandler getHandlerMap(String tableName) {
        return tableHandlerMap.get(tableName);
    }


    /**
     * 获取所有EntryHandler信息
     *
     * @param entryHandlers 所有EntryHandler
     * @return map类型，key：CanalTable注解的value名称   value：对应的EntryHandler
     */
    private Map<String, CanalEntryHandler> getTableHandler(List<? extends CanalEntryHandler> entryHandlers) {
        if (CollUtil.isEmpty(entryHandlers)) {
            return CollUtil.newHashMap();
        }
        Map<String, CanalEntryHandler> tableHandlerMap = new HashMap<>(entryHandlers.size());
        for (CanalEntryHandler entryHandler : entryHandlers) {
            String tableName = FieldUtil.getTableGenericProperties(entryHandler);
            if (StrUtil.isNotBlank(tableName)) {
                tableHandlerMap.putIfAbsent(tableName, entryHandler);
            }
        }
        return tableHandlerMap;
    }
}
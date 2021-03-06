package com.sisyphus.demo.canal.job;

import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sisyphus.demo.canal.handler.CanalEntryHandler;
import com.sisyphus.demo.canal.handler.CanalMessageHandler;
import com.sisyphus.demo.canal.properties.CanalClientProperties;
import com.sisyphus.demo.canal.util.FieldUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zard
 * @date Created in 14/04/2022 08:59
 */
@Slf4j
@Component
@EnableConfigurationProperties(CanalClientProperties.class)
public class CanalScheduling {

    @Autowired
    private CanalMessageHandler messageHandler;

    @Autowired
    private CanalClientProperties canalClientProperties;

    @Resource
    private CanalConnector canalConnector;

    @Scheduled(fixedDelay = 100)
    public void run() {
        try {
            Message message = canalConnector.getWithoutAck(canalClientProperties.getBatchSize());
            long batchId = message.getId();
            try {
                List<Entry> entries = message.getEntries();
                if (batchId != -1 && entries.size() > 0) {
                    entries.forEach(entry -> {
                        if (entry.getEntryType() == EntryType.ROWDATA) {
                            handlerEntry(entry);
                        }
                    });
                }
                canalConnector.ack(batchId);
            } catch (Exception e) {
                log.error("???????????????????????????????????????message={},????????????={}", JSON.toJSONString(message), e.getMessage(), e);
                if (canalClientProperties.getAcknowledgeMode()) {
                    canalConnector.rollback(batchId);
                } else {
                    canalConnector.ack(batchId);
                }
            }
        } catch (Exception e) {
            log.error("canal_scheduled?????????", e);
        }
    }

    /**
     * ???handlerEntry?????????
     *
     * @param entry ??????
     */
    private void handlerEntry(Entry entry) {
        //????????????
        String table = entry.getHeader().getTableName();

        CanalEntry.RowChange change;
        try {
            change = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (InvalidProtocolBufferException e) {
            log.error("canalEntry_parser_error,??????CanalEntry??????RowChange?????????", e);
            return;
        }
        EventType eventType = entry.getHeader().getEventType();

        //table??????????????????
        CanalEntryHandler handlerMap = messageHandler.getHandlerMap(table);


        List<CanalEntry.RowData> rowDatasList = change.getRowDatasList();
        for (CanalEntry.RowData rowData : rowDatasList) {
            Object afterObj = getAfterObj(table, rowData);
            Object beforeObj = getBeforeObj(table, rowData);
            try {
                switch (eventType) {
                    case INSERT:
                        handlerMap.insert(afterObj);
                        break;
                    case UPDATE:
                        handlerMap.update(beforeObj, afterObj);
                        break;
                    case DELETE:
                        handlerMap.delete(beforeObj);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                //??????????????????
                log.error("canal???????????????????????????::{}", e.getMessage(), e);
            }
        }
    }

    /**
     * ????????????????????????
     *
     * @param table   ???
     * @param rowData ????????????
     * @return ??????????????????
     */
    @SneakyThrows
    private Object getBeforeObj(String table, CanalEntry.RowData rowData) {
        CanalEntryHandler entryHandler = messageHandler.getHandlerMap(table);
        Object beforeObj = ReflectUtil.newInstance(FieldUtil.getTableClass(entryHandler));
        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            FieldUtil.setFieldValue(beforeObj, column.getName(), column.getValue());
        }
        return beforeObj;
    }

    /**
     * ????????????????????????
     *
     * @param table   ???
     * @param rowData ????????????
     * @return ??????????????????
     */
    @SneakyThrows
    private Object getAfterObj(String table, CanalEntry.RowData rowData) {
        CanalEntryHandler entryHandler = messageHandler.getHandlerMap(table);
        Object afterObj = ReflectUtil.newInstance(FieldUtil.getTableClass(entryHandler));
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : afterColumnsList) {
            FieldUtil.setFieldValue(afterObj, column.getName(), column.getValue());
        }
        return afterObj;
    }
}

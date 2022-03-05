package com.sisyphus.demo.squirrel.fsm;

import org.squirrelframework.foundation.fsm.Converter;

/**
 * @author zard
 * @date Created in 05/03/2022 22:34
 */
public class OrderEventConverter implements Converter<OrderEvent> {

    @Override
    public String convertToString(OrderEvent orderEvent) {
        return orderEvent.name();
    }

    @Override
    public OrderEvent convertFromString(String name) {
        return OrderEvent.valueOf(name);
    }
}

package com.sisyphus.demo.squirrel.fsm;

import org.squirrelframework.foundation.fsm.Converter;

/**
 * @author zard
 * @date Created in 05/03/2022 22:34
 */
public class OrderStateConverter implements Converter<OrderState> {

    @Override
    public String convertToString(OrderState orderState) {
        return orderState.name();
    }

    @Override
    public OrderState convertFromString(String name) {
        return OrderState.valueOf(name);
    }
}
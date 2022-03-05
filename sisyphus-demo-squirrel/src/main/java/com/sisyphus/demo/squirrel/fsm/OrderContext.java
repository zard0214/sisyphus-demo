package com.sisyphus.demo.squirrel.fsm;

import com.sisyphus.demo.squirrel.domain.Order;

/**
 * @author zard
 * @date Created in 05/03/2022 22:32
 */
public class OrderContext {

    public OrderContext(Order order) {
        this.order = order;
    }

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
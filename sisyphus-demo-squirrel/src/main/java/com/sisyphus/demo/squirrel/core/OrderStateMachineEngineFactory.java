package com.sisyphus.demo.squirrel.core;

import com.sisyphus.demo.squirrel.fsm.OrderContext;
import com.sisyphus.demo.squirrel.fsm.OrderEvent;
import com.sisyphus.demo.squirrel.fsm.OrderState;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zard
 * @date Created in 05/03/2022 22:38
 */
@Service
public class OrderStateMachineEngineFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void fire(OrderContext orderContext, OrderEvent orderEvent) {
        Map<String, AbstractOrderStatusMachineEngine> orderStatusMachineEngineMap = applicationContext.getBeansOfType(AbstractOrderStatusMachineEngine.class);
        boolean accept = false;
        for (AbstractOrderStatusMachineEngine orderStatusMachineEngine : orderStatusMachineEngineMap.values()) {
            if (orderStatusMachineEngine.accept(OrderState.getState(orderContext.getOrder().getStatus()))) {
                accept = true;
                orderStatusMachineEngine.fire(orderEvent, orderContext);
            }
        }
        if (!accept) {
            throw new RuntimeException("fail");
        }
    }
}
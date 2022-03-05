package com.sisyphus.demo.squirrel.core;

import com.sisyphus.demo.squirrel.fsm.OrderState;
import org.springframework.stereotype.Service;

/**
 * @author zard
 * @date Created in 05/03/2022 22:38
 */
@Service
public class OrderStateMachineEngine extends AbstractOrderStatusMachineEngine<OrderStateMachine> {

    @Override
    protected boolean accept(OrderState orderState) {
        return OrderState.INIT == orderState;
    }

}
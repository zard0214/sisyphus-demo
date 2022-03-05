package com.sisyphus.demo.squirrel.core;

import com.sisyphus.demo.squirrel.domain.Order;
import com.sisyphus.demo.squirrel.fsm.OrderContext;
import com.sisyphus.demo.squirrel.fsm.OrderEvent;
import com.sisyphus.demo.squirrel.fsm.OrderState;
import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.annotation.*;

/**
 * @author zard
 * @date Created in 05/03/2022 22:37
 */
@States({
        @State(name = "INIT", entryCallMethod = "entryStateInit", exitCallMethod = "exitStateInit", initialState = true),
        @State(name = "WAIT_PAY", entryCallMethod = "entryStateWaitPay", exitCallMethod = "exitStateWaitPay"),
        @State(name = "PAID", entryCallMethod = "entryStatePaid", exitCallMethod = "exitStatePaid"),
        @State(name = "SHIPPED", entryCallMethod = "entryStateShipped", exitCallMethod = "exitStateShipped"),
        @State(name = "SUCCESS", entryCallMethod = "entryStateSuccess", exitCallMethod = "exitStateSuccess"),
        @State(name = "COMPLETE", entryCallMethod = "entryStateComplete", exitCallMethod = "exitStateComplete")
})
@Transitions(value = {
        @Transit(from = "INIT", to = "WAIT_PAY", on = "CREATE", callMethod = "create"),
        @Transit(from = "WAIT_PAY", to = "PAID", on = "PAY", callMethod = "pay"),
        @Transit(from = "PAID", to = "SHIPPED", on = "DELIVERY", callMethod = "delivery"),
        @Transit(from = "SHIPPED", to = "SUCCESS", on = "RECEIVED", callMethod = "receive"),
        @Transit(from = "SUCCESS", to = "COMPLETE", on = "COMPLETE", callMethod = "complete")
})
@StateMachineParameters(stateType = OrderState.class, eventType = OrderEvent.class, contextType = OrderContext.class)
public class OrderStateMachine extends BaseOrderStateMachine  {


    public OrderStateMachine(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Override
    protected void afterTransitionCompleted(Object fromState, Object toState, Object event, Object context) {
        if (fromState instanceof OrderState && toState instanceof OrderState) {
            OrderContext orderContext = (OrderContext) context;
            Order order = orderContext.getOrder();
            order.setStatus(((OrderState) toState).getCode());
//            orderDTOMapper.updateById(order);
        }
    }

    public void create(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("create");
    }

    public void pay(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("pay");
    }

    public void delivery(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("delivery");
    }

    public void receive(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("receive");
    }

    public void complete(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("complete");
    }
//
//    public void entryStateInit(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStateInit");
//    }
//
//    public void exitStateInit(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStateInit");
//    }
//
//    public void entryStateWaitPay(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStateWaitPay");
//    }
//
//    public void exitStateWaitPay(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStateWaitPay");
//    }
//
//    public void entryStateWaitSend(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStateWaitSend");
//    }
//
//    public void exitStateWaitSend(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStateWaitSend");
//    }
//
//    public void entryStatePartSend(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStatePartSend");
//    }
//
//    public void exitStatePartSend(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStatePartSend");
//    }
//
//    public void entryStateWaitReceive(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStateWaitReceive");
//    }
//
//    public void exitStateWaitReceive(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStateWaitReceive");
//    }
//
//    public void entryStateComplete(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("entryStateComplete");
//    }
//
//    public void exitStateComplete(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
//        System.out.println("exitStateComplete");
//    }
}

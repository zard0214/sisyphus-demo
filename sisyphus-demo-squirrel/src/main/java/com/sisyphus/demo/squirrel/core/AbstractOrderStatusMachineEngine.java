package com.sisyphus.demo.squirrel.core;

import com.sisyphus.demo.squirrel.fsm.OrderContext;
import com.sisyphus.demo.squirrel.fsm.OrderEvent;
import com.sisyphus.demo.squirrel.fsm.OrderState;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.GenericTypeResolver;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * @author zard
 * @date Created in 05/03/2022 22:36
 */
public abstract class AbstractOrderStatusMachineEngine<T extends UntypedStateMachine> implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    protected UntypedStateMachineBuilder builder;

    public AbstractOrderStatusMachineEngine() {
        Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractOrderStatusMachineEngine.class);
        builder = StateMachineBuilderFactory.create(genericType, ApplicationContext.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void fire(OrderEvent orderEvent, OrderContext orderContext) {
        T stateMachine = builder.newUntypedStateMachine(OrderState.getState(orderContext.getOrder().getStatus()),
                StateMachineConfiguration.create().enableDebugMode(true).enableAutoStart(true),
                applicationContext);
        try {
            stateMachine.fire(orderEvent, orderContext);
        } catch (Exception e) {
        }
    }


    protected abstract boolean accept(OrderState orderState);

}

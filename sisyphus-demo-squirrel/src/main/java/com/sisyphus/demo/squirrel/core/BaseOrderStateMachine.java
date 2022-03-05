package com.sisyphus.demo.squirrel.core;

import org.springframework.context.ApplicationContext;

/**
 * @author zard
 * @date Created in 05/03/2022 22:37
 */
public abstract class BaseOrderStateMachine extends AbstractUntypedStateMachine  {

//    protected OmcOrderMapper orderDTOMapper;

    public BaseOrderStateMachine(ApplicationContext applicationContext) {
//        this.orderDTOMapper = applicationContext.getBean(OmcOrderMapper.class);
    }
}

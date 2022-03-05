package com.sisyphus.demo.squirrel.fsm;

import org.squirrelframework.foundation.fsm.Condition;

/**
 * @author zard
 * @date Created in 05/03/2022 22:32
 */
public class OrderCondition implements Condition {

    @Override
    public boolean isSatisfied(Object context) {
        return true;
    }

    @Override
    public String name() {
        return "hahah";
    }
}
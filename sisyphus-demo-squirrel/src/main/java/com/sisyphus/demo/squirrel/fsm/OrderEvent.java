package com.sisyphus.demo.squirrel.fsm;

/**
 * @author zard
 * @date Created in 05/03/2022 22:34
 */
public enum OrderEvent {
    /**
     * create
     */
    CREATE("CREATE", 0),
    /**
     * cancel
     */
    CANCEL("CANCEL", 1),
    /**
     * pay
     */
    PAY("PAY", 2),
    /**
     * delivery
     */
    DELIVERY("DELIVERY", 3),
    /**
     * received
     */
    RECEIVED("RECEIVED", 4),
    /**
     * complete
     */
    COMPLETE("COMPLETE", 5);

    OrderEvent(String type, int code) {
        this.type = type;
        this.code = code;
    }

    /**
     * name
     */
    final String type;

    /**
     * type
     */
    final int code;

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }
}

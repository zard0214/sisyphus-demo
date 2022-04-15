package com.sisyphus.demo.kafka.producer;

import lombok.Data;

import java.util.Date;

/**
 * @author zard
 * @date Created in 15/04/2022 03:56
 */
@Data
public class Message {

    private String id;

    private String msg;

    private Date sendTime;

}
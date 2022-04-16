package com.sisyphus.demo.seata.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhecheng.zhao
 * @date Created in 18/05/2021 00:00
 */

/**
 * this is the get set annotation from lombok we dont need write the get and set function
 * the get function will auto create in complit
 */
@Data
public class BaseDTO implements Serializable {

    private Long id;

    /**
     * creator name
     */
    private String creator;

    /**
     * creator id
     */
    private Long creatorId;

    /**
     * create time
     */
    private Date gmtCreated;

    /**
     * last modifier name
     */
    private String lastOperator;

    /**
     * last modifier id
     */
    private Long lastOperatorId;

    /**
     * last modify time
     */
    private Date gmtModified;
}

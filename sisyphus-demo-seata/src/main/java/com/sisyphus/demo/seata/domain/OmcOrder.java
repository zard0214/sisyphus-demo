package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zard
 * @date Created in 05/03/2022 00:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "s_omc_order")
@Alias(value = "omcOrder")
public class OmcOrder extends BaseDO {

    /**
     * optimisic lock
     */
    @Version
    private Integer version;

    /**
     * orderNo
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * userId
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * shippingId
     */
    @TableField(value = "shipping_id")
    private Long shippingId;

    /**
     * payment
     */
    @TableField(value = "payment")
    private BigDecimal payment;

    /**
     * payment_type
     */
    @EnumValue
    @TableField(value = "payment_type")
    private Integer paymentType;

    /**
     * postage
     */
    @TableField(value = "postage")
    private BigDecimal postage;

    /**
     * order status:0-cancel, 10-unpay，20-paid，40-shipped，50-success，60-finish
     */
    @EnumValue
    @TableField(value = "status")
    private Integer status;

    /**
     * paymentTime
     */
    @TableField(value = "payment_time")
    private Date paymentTime;

    /**
     * sendTime
     */
    @TableField(value = "send_time")
    private Date sendTime;

    /**
     * endTime
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * closeTime
     */
    @TableField(value = "close_time")
    private Date closeTime;

//    private List<OmcOrderDetailDTO> omcOrderDetailList;
}

package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zard
 * @date Created in 05/03/2022 00:45
 */
@Data
@ToString
public class OmcOrderDTO extends BaseDTO {

    /**
     * optimisim lock
     */
    private Integer version;

    /**
     * orderNo
     */
    private String orderNo;

    /**
     * userId
     */
    private Long userId;

    /**
     * shippingId
     */
    private Long shippingId;

    /**
     * payment
     */
    private BigDecimal payment;

    /**
     * payment_type
     */
    private Integer paymentType;

    /**
     * postage
     */
    private BigDecimal postage;

    /**
     * order status:0-cancel, 10-unpay，20-paid，40-shipped，50-success，60-finish
     */
    private Integer status;

    /**
     * paymentTime
     */
    private Date paymentTime;

    /**
     * sendTime
     */
    private Date sendTime;

    /**
     * endTime
     */
    private Date endTime;

    /**
     * closeTime
     */
    private Date closeTime;

    private List<OmcOrderDetailDTO> omcOrderDetailList;
}

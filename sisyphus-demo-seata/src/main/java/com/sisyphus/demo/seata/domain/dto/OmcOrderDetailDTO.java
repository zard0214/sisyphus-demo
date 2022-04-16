package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zard
 * @date Created in 05/03/2022 00:45
 */
@Data
@ToString
public class OmcOrderDetailDTO extends BaseDTO {

    /**
     * optimism lock
     */
    private Integer version;

    /**
     * detailNo
     */
    private String detailNo;

    /**
     * orderNo
     */
    private String orderNo;

    /**
     * userId
     */
    private Long userId;

    /**
     * productId
     */
    private Long productId;

    /**
     * productName
     */
    private String productName;

    /**
     * currentUnitPrice
     */
    private BigDecimal currentUnitPrice;

    /**
     * quantity
     */
    private Integer quantity;

    /**
     * totalPrice
     */
    private BigDecimal totalPrice;
}

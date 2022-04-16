package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zard
 * @date Created in 05/03/2022 00:40
 */
@Data
@ToString
public class OmcBasketDTO extends BaseDTO {

    /**
     * optimisic lock
     */
    private Integer version;

    /**
     * userId
     */
    private Long userId;

    /**
     * productId
     */
    private Long productId;

    /**
     * categoryId
     */
    private Long categoryId;

    /**
     * categoryName
     */
    private String categoryName;

    /**
     * quantity
     */
    private Integer quantity;

    /**
     * checked,1=yes,0=no
     */
    private Integer checked;

    /**
     * name
     */
    private String name;

    /**
     * price
     */
    private BigDecimal price;

    /**
     * stock
     */
    private Integer stock;

    private MdcProductDTO mdcProductDTO;
}

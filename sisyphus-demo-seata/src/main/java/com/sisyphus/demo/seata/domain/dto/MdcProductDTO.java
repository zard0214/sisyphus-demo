package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zard
 * @date Created in 02/03/2022 15:41
 */
@Data
@ToString
public class MdcProductDTO extends BaseDTO {

    /**
     * optimism lock
     */
    private Integer version;

    /**
     * productCode
     */
    private String productCode;

    /**
     * categoryId
     */
    private Integer categoryId;

    /**
     * name
     */
    private String name;

    /**
     * name
     */
    private String subtitle;

    /**
     * mainImage
     */
    private String mainImage;

    /**
     * subImages
     */
    private String subImages;

    /**
     * detail
     */
    private String detail;

    /**
     * price
     */
    private BigDecimal price;

    /**
     * stock
     */
    private Integer stock;

    /**
     * num
     */
    private Integer num;

    /**
     * status
     */
    private Integer status;
}

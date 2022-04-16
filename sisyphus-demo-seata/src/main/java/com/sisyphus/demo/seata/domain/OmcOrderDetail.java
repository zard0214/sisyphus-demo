package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @author zard
 * @date Created in 05/03/2022 00:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "s_omc_order_detail")
@Alias(value = "omcOrderDetail")
public class OmcOrderDetail extends BaseDO {

    @TableId(value = "id",
            type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * optimisic lock
     */
    @Version
    private Integer version;

    /**
     * detailNo
     */
    @TableField(value = "detail_no")
    private String detailNo;

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
     * productId
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * productName
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * productName
     */
    @TableField(value = "product_image")
    private String productImage;

    /**
     * current_unit_price
     */
    @TableField(value = "current_unit_price")
    private BigDecimal currentUnitPrice;

    /**
     * quantity
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * total_price
     */
    @TableField(value = "total_price")
    private BigDecimal totalPrice;
}

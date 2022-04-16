package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author zard
 * @date Created in 05/03/2022 00:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "s_omc_basket")
@Alias(value = "omcBasket")
public class OmcBasket extends BaseDO {

    @TableId(value = "id",
            type = IdType.ASSIGN_ID)
    private Long id;
    
    /**
     * optimisic lock
     */
    @Version
    private Integer version;

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
     * quantity
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * checked,1=yes,0=no
     */
    @TableField(value = "checked")
    private Integer checked;
}

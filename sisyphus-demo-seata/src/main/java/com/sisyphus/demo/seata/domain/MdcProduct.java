package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @author zard
 * @date Created in 02/03/2022 15:41
 */
@Data
@TableName(value = "s_mdc_product")
@Alias(value = "mdcProduct")
public class MdcProduct extends BaseDO {

    /**
     * optimisic lock
     */
    @Version
    private Integer version;

    @TableField(value = "product_code")
    private String productCode;

    @TableField(value = "category_id")
    private Integer categoryId;

    @TableField(value = "subtitle")
    private String subtitle;

    @TableField(value = "name")
    private String name;

    @TableField(value = "main_image")
    private String mainImage;

    @TableField(value = "sub_images")
    private String subImages;

    @TableField(value = "detail")
    private String detail;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "stock")
    private Integer stock;

    @TableField(value = "status")
    private Integer status;
}

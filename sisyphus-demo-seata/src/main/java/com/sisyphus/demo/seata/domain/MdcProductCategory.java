package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author zard
 * @date Created in 02/03/2022 15:39
 */
@Data
@TableName(value = "s_mdc_product_category")
@Alias(value = "mdcProductCategory")
public class MdcProductCategory extends BaseDO {

    /**
     * version
     */
    @Version
    private Integer version;

    /**
     * categoryCode
     */
    @TableField(value = "category_code")
    private String categoryCode;

    /**
     * img_id
     */
    @TableField(value = "img_id")
    private String imgId;

    /**
     * name
     */
    @TableField(value = "name")
    private String name;

    /**
     * pid
     */
    @TableField(value = "pid")
    private String pid;

    /**
     * status
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * sort_order
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;


}

package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

/**
 * @author zard
 * @date Created in 02/03/2022 15:39
 */
@Data
@ToString
public class MdcProductCategoryDTO extends BaseDTO {
    /**
     * version
     */
    private Integer version;

    /**
     * version
     */
    private String categoryCode;

    /**
     * img_id
     */
    private String imgId;

    /**
     * name
     */
    private String name;

    /**
     * pid
     */
    private String pid;

    /**
     * status
     */
    private Integer status;

    /**
     * sort_order
     */
    private Integer sortOrder;

}

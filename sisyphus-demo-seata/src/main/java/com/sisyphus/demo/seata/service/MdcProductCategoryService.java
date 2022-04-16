package com.sisyphus.demo.seata.service;


import com.sisyphus.demo.seata.common.IService;
import com.sisyphus.demo.seata.domain.MdcProductCategory;
import com.sisyphus.demo.seata.domain.dto.MdcProductCategoryDTO;

import java.util.List;

/**
 *
 *  it is product category interface
 * @author zard
 * @date Created in 02/03/2022 15:50
 */
public interface MdcProductCategoryService extends IService<MdcProductCategory> {

    /**
     * find the product category by primary key (id)
     * @param categorId
     * @return
     */
    MdcProductCategoryDTO findByCategoryId(Integer categorId);

    /**
     * find the all product category (Pagination gets data is better)
     * @return
     */
    List<MdcProductCategoryDTO> findList();

    /**
     * save ProductCategory batch
     * @param entityList
     * @param batchSize
     * @return
     */
    boolean saveMdcProductCategoryBatch(List<MdcProductCategory> entityList, int batchSize);

}

package com.sisyphus.demo.seata.service;


import com.sisyphus.demo.seata.common.IService;
import com.sisyphus.demo.seata.domain.MdcProduct;
import com.sisyphus.demo.seata.domain.dto.MdcProductDTO;

import java.util.List;

/**
 *  it is product service interface
 * @author zard
 * @date Created in 02/03/2022 15:49
 */
public interface MdcProductService extends IService<MdcProduct> {

    /**
     * find by Category_id
     * @param categoryId
     * @return
     */
    List<MdcProductDTO> findByCategoryId(Integer categoryId);

    /**
     * select product by product id
     * @param id
     * @return
     */
    MdcProduct selectById(String id);

    /**
     * delete product by product id
     * update is_delete field
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     *  insert product
     * @param mdcProduct
     * @return
     */
    int insert(MdcProduct mdcProduct);

    /**
     * find all
     * @return
     */
    List<MdcProductDTO> findList();

    /**
     * get total stock of product
     * @return
     */
    int getTotalStock();

    /**
     *  get total stock fo product by category id
     * @return
     */
    int getTotalStockByCategoryId(Integer categoryId);

    /**
     *  update stock by id
     * @param mdcProduct
     * @return
     */
    boolean updateById(MdcProduct mdcProduct);
}

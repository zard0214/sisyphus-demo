package com.sisyphus.demo.seata.service;


import com.sisyphus.demo.seata.common.IService;
import com.sisyphus.demo.seata.domain.OmcBasket;
import com.sisyphus.demo.seata.domain.dto.OmcBasketDTO;

import java.util.List;

/**
 * it is Omc baseket service interface
 * @author zard
 * @date Created in 01/03/2022 19:39
 */
public interface OmcBasketService extends IService<OmcBasket> {

    /**
     * findByUserId
     * @param userId
     * @return
     */
    List<OmcBasketDTO> findByUserId(Long userId);

    /**
     * find basket by userId and productId
     * @param userId
     * @param productId
     * @return
     */
    OmcBasketDTO findByUserIdAndProductId(Long userId, Long productId);

    /**
     *
     * @param entity
     * @return
     */
    int insert(OmcBasket entity);

    /**
     * update basket info
     * @param byUserIdAndProductId
     */
    void update(OmcBasket byUserIdAndProductId);

    /**
     * delete basket by id
     * @param id
     */
    void deleteById(String id);

    /**
     * saveOrUpdateOmcBasketBatch
     * @param entityList
     * @param batchSize
     * @return
     */
    boolean saveOrUpdateOmcBasketBatch(List<OmcBasket> entityList, int batchSize);
}


package com.sisyphus.demo.seata.service;


import com.sisyphus.demo.seata.common.IService;
import com.sisyphus.demo.seata.domain.OmcOrderDetail;
import com.sisyphus.demo.seata.domain.dto.OmcOrderDetailDTO;

import java.util.Collection;
import java.util.List;

/**
 * it is Omc order detail service interface
 * @author zard
 * @date Created in 01/03/2022 19:39
 */
public interface OmcOrderDetailService extends IService<OmcOrderDetail> {

    /**
     * insert order detail
     * @param entity
     * @return
     */
    int insert(OmcOrderDetail entity);

    /**
     *
     * @param orderNo
     * @return
     */
    List<OmcOrderDetailDTO> findDetailByOrderNo(String orderNo);

    /**
     * save order detail batch
     * @param entityList
     * @param batchSize
     * @return
     */
    boolean saveOmcOrderDetailBatch(Collection<OmcOrderDetail> entityList, int batchSize);
}


package com.sisyphus.demo.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sisyphus.demo.seata.domain.OmcOrderDetail;
import com.sisyphus.demo.seata.domain.dto.OmcOrderDetailDTO;
import com.sisyphus.demo.seata.mapper.OmcOrderDetailMapper;
import com.sisyphus.demo.seata.service.OmcOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author zard
 * @date Created in 01/03/2022 19:40
 */
@Slf4j
/**
 * use this annotaton to register omcOrderDetailService to spring container
 */
@Service
public class OmcOrderDetailServiceImpl extends ServiceImpl<OmcOrderDetailMapper, OmcOrderDetail> implements OmcOrderDetailService {

    @Override
    public int insert(OmcOrderDetail entity) {
        return getBaseMapper().insert(entity);
    }

    @Override
    public List<OmcOrderDetailDTO> findDetailByOrderNo(String orderNo) {
        return getBaseMapper().findDetailByOrderNo(orderNo);
    }

    @Override
    public boolean saveOmcOrderDetailBatch(Collection<OmcOrderDetail> entityList, int batchSize){
        return saveBatch(entityList,batchSize);
    }
}

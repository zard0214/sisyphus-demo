package com.sisyphus.demo.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sisyphus.demo.seata.domain.OmcBasket;
import com.sisyphus.demo.seata.domain.dto.OmcBasketDTO;
import com.sisyphus.demo.seata.mapper.OmcBasketMapper;
import com.sisyphus.demo.seata.service.OmcBasketService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zard
 * @date Created in 01/03/2022 19:40
 */
/**
 * use this annotaton to register omcBasketService to spring container
 */
@Service
public class OmcBasketServiceImpl extends ServiceImpl<OmcBasketMapper, OmcBasket> implements OmcBasketService {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public List<OmcBasketDTO> findByUserId(Long userId) {
        return getBaseMapper().findByUserId(userId);
    }

    @Override
    public OmcBasketDTO findByUserIdAndProductId(Long userId, Long productId) {
        return getBaseMapper().findByUserIdAndProductId(userId, productId);
    }

    @Override
    public int insert(OmcBasket entity) {
        return getBaseMapper().insert(entity);
    }

    @Override
    public void update(OmcBasket byUserIdAndProductId) {
        getBaseMapper().updateById(byUserIdAndProductId);
    }

    @Override
    public void deleteById(String id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public boolean saveOrUpdateOmcBasketBatch(List<OmcBasket> entityList, int batchSize){
        return getBaseMapper().batchUpdate(entityList);
    }


}

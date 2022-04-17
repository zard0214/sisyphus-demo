package com.sisyphus.demo.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sisyphus.demo.seata.domain.MdcProduct;
import com.sisyphus.demo.seata.domain.dto.MdcProductDTO;
import com.sisyphus.demo.seata.mapper.MdcProductMapper;
import com.sisyphus.demo.seata.service.MdcProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zard
 * @date Created in 02/03/2022 16:11
 */
@Slf4j
@Service
public class MdcProductServiceImpl extends ServiceImpl<MdcProductMapper, MdcProduct> implements MdcProductService {

    @Override
    public List<MdcProductDTO> findByCategoryId(Integer categorId) {
        return getBaseMapper().findByCategoryId(categorId);
    }

    @Override
    public MdcProduct selectById(String id) {
        return getBaseMapper().selectById(id);
    }

    @Override
    public int deleteById(String id) {
        return getBaseMapper().deleteById(id);
    }

    @Override
    public int insert(MdcProduct mdcProduct) {
        return getBaseMapper().insert(mdcProduct);
    }

    @Override
    public boolean updateById(MdcProduct entity) {
        return getBaseMapper().updateById(entity) == 1 ? true:false;
    }

    @Override
    public List<MdcProductDTO> findList() {
        return getBaseMapper().findList();
    }

    @Override
    public int getTotalStock() {
        return getBaseMapper().findList().stream().
                mapToInt(MdcProductDTO::getStock).sum();
    }

    @Override
    public int getTotalStockByCategoryId(Integer categoryId) {
        return getBaseMapper().findByCategoryId(categoryId).stream().
                mapToInt(MdcProductDTO::getStock).sum();
    }

}

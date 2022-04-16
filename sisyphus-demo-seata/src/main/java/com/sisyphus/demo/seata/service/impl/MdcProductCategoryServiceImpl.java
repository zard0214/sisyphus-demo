package com.sisyphus.demo.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sisyphus.demo.seata.domain.MdcProductCategory;
import com.sisyphus.demo.seata.domain.dto.MdcProductCategoryDTO;
import com.sisyphus.demo.seata.mapper.MdcProductCategoryMapper;
import com.sisyphus.demo.seata.service.MdcProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zard
 * @date Created in 02/03/2022 16:11
 */
@Slf4j
@Service(value = "mdcProductCategoryService")
public class MdcProductCategoryServiceImpl extends ServiceImpl<MdcProductCategoryMapper, MdcProductCategory> implements MdcProductCategoryService {

    @Override
    public MdcProductCategoryDTO findByCategoryId(Integer categorId) {
        return getBaseMapper().findByCategoryId(categorId);
    }

    @Override
    public List<MdcProductCategoryDTO> findList() {
        return getBaseMapper().findList();
    }

    @Override
    public boolean saveMdcProductCategoryBatch(List<MdcProductCategory> entityList, int batchSize) {
        return saveBatch(entityList, batchSize);
    }

}

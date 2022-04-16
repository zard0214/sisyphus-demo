package com.sisyphus.demo.seata.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sisyphus.demo.seata.common.IMapper;
import com.sisyphus.demo.seata.domain.MdcProductCategory;
import com.sisyphus.demo.seata.domain.dto.MdcProductCategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author zhecheng.zhao
 * @date Created in 21/05/2021 06:46
 */
@Mapper
@Repository
/**
 * using this annotation to change the datasource
 */
@DS("mdc")
public interface MdcProductCategoryMapper extends IMapper<MdcProductCategory> {

    MdcProductCategoryDTO findByCategoryId(@Param("categoryId") Integer categoryId);

    List<MdcProductCategoryDTO> findList();
}

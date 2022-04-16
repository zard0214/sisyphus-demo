package com.sisyphus.demo.seata.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sisyphus.demo.seata.common.IMapper;
import com.sisyphus.demo.seata.domain.OmcOrder;
import com.sisyphus.demo.seata.domain.dto.OmcOrderDTO;
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
@DS("omc")
public interface OmcOrderMapper extends IMapper<OmcOrder> {

    List<OmcOrderDTO> findByUserId(@Param("userId") Long userId);

    List<OmcOrderDTO> findList();
}

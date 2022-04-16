package com.sisyphus.demo.seata.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sisyphus.demo.seata.common.IMapper;
import com.sisyphus.demo.seata.domain.OmcBasket;
import com.sisyphus.demo.seata.domain.dto.OmcBasketDTO;
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
public interface OmcBasketMapper extends IMapper<OmcBasket> {

    List<OmcBasketDTO> findByUserId(@Param("userId") Long userId);

    OmcBasketDTO findByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    boolean batchUpdate(@Param(value = "baskets") List<OmcBasket> matchs);
}

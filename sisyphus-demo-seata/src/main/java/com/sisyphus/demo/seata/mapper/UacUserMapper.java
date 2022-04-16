package com.sisyphus.demo.seata.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sisyphus.demo.seata.common.IMapper;
import com.sisyphus.demo.seata.domain.UacUser;
import com.sisyphus.demo.seata.domain.dto.UacUserDTO;
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
@DS("uac")
public interface UacUserMapper extends IMapper<UacUser> {

    UacUserDTO findByPhone(@Param("phone") String phone);

    UacUserDTO findByLoginName(@Param("loginName") String loginName);

    List<UacUserDTO> findUserByType(@Param("type") String type);
}

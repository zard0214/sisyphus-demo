package com.sisyphus.demo.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sisyphus.demo.seata.domain.UacUser;
import com.sisyphus.demo.seata.domain.dto.UacUserDTO;
import com.sisyphus.demo.seata.mapper.UacUserMapper;
import com.sisyphus.demo.seata.service.UacUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zard
 * @date Created in 01/03/2022 19:40
 */
@Slf4j
/**
 * use this annotaton to register uacUserService to spring container
 */
@Service(value = "uacUserService")
public class UacUserServiceImpl extends ServiceImpl<UacUserMapper, UacUser> implements UacUserService {

    /**
     * using user DAO to get the data
     * @param loginName
     * @return
     */
    @Override
    public UacUserDTO findByLoginName(String loginName) {
        return getBaseMapper().findByLoginName(loginName);
    }

    @Override
    public boolean updateById(UacUser entity) {
        return getBaseMapper().updateById(entity) == 1 ? true:false;
    }

    @Override
    public List<UacUserDTO> findUserByType(String type) {
        return getBaseMapper().findUserByType(type);
    }

    @Override
    public UacUser selectById(Long id) {
        return getBaseMapper().selectById(id);
    }

    @Override
    public int getCount() {
        return getBaseMapper().selectCount(new QueryWrapper<>());
    }

}

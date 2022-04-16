package com.sisyphus.demo.seata.service;

import com.sisyphus.demo.seata.common.IService;
import com.sisyphus.demo.seata.domain.UacUser;
import com.sisyphus.demo.seata.domain.dto.UacUserDTO;

import java.util.List;

/**
 * it is User service interface
 * @author zard
 * @date Created in 01/03/2022 19:39
 */
public interface UacUserService extends IService<UacUser> {

    /**
     * find the account by username
     * @param loginName
     * @return
     */
    UacUserDTO findByLoginName(String loginName);

    /**
     * update user entity by using primary key(id)
     * @param uacUser
     * @return
     */
    boolean updateById(UacUser uacUser);

    /**
     * find user by user type
     * @param userType
     * @return
     */
    List<UacUserDTO> findUserByType(String userType);

    /**
     * get count of user
     * @return
     */
    int getCount();


    /**
     * select user by id
     * @param id
     * @return
     */
    UacUser selectById(Long id);

}


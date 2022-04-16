package com.sisyphus.demo.seata.domain.dto;

import com.sisyphus.demo.seata.common.BaseDTO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhecheng.zhao
 * @date Created in 22/05/2021 10:28
 */
@Data
@ToString
public class UacUserDTO extends BaseDTO {

    /**
     * version number
     */
    private Integer version;

    /**
     * gender
     */
    private Integer gender;

    /**
     * login name
     */
    private String loginName;

    /**
     * login password
     */
    private String loginPwd;

    /**
     * 工号
     */
    private String userCode;

    /**
     * nickname
     */
    private String userName;

    /**
     * phone number
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * status of the account
     */
    private String status;

    /**
     * where the user from
     */
    private String userSource;

    /**
     * user type
     */
    private Integer type;

    /**
     * last login ip
     */
    private String lastLoginIp;

    /**
     * last login location
     */
    private String lastLoginLocation;

    /**
     * describe of this account
     */
    private String remark;

    /**
     * image of the account
     */
    private String avatar;

    /**
     * tenant id
     */
    private Long tenantId;

    /**
     * last login time
     */
    private Date lastLoginTime;

    /**
     * password error count
     */
    private Integer pwdErrorCount;

    /**
     * last password error time
     */
    private Date pwdErrorTime;

    /**
     * which group does this acccount belong to
     */
    private Long groupId;

    private String groupName;


}

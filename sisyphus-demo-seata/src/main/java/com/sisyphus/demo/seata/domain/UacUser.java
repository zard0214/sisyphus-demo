package com.sisyphus.demo.seata.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.sisyphus.demo.seata.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author zhecheng.zhao
 * @date Created in 22/05/2021 06:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "s_uac_user")
@Alias(value = "uacUser")
public class UacUser extends BaseDO {

    /**
     * optimisic lock
     */
    @Version
    private Integer version;

    /**
     * gender
     */
    @EnumValue
    @TableField(value = "gender")
    private Integer gender;

    /**
     * login name
     */
    @TableField(value = "login_name")
    private String loginName;

    /**
     * paswword
     */
    @TableField(value = "login_pwd")
    private String loginPwd;

    /**
     * user code
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * nick name
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * phone number
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * email address
     */
    @TableField(value = "email")
    private String email;

    /**
     * status of the account
     */
    @EnumValue
    @TableField(value = "status")
    private String status;

    /**
     * where the account from
     */
    @EnumValue
    @TableField(value = "user_source")
    private String userSource;

    /**
     * user
     */
    @EnumValue
    @TableField(value = "type")
    private Integer type;

    /**
     * last login ip
     */
    @TableField(value = "last_login_ip")
    private String lastLoginIp;

    /**
     * last login location address
     */
    @TableField(value = "last_login_location")
    private String lastLoginLocation;

    /**
     * describe
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * image of the account
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * last login time
     */
    @TableField(value = "last_login_time")
    private Date lastLoginTime;

    /**
     * password error count
     */
    @TableField(value = "pwd_error_count")
    private Integer pwdErrorCount;

    /**
     * password error time
     */
    @TableField(value = "pwd_error_time")
    private Date pwdErrorTime;

    /**
     * where the account belong to
     */
    private Long groupId;

    private String groupName;
}

package com.sisyphus.demo.seata.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * this entity including all the fields the table must have :
 * @author zhecheng.zhao
 * @date Created in 18/05/2021 00:00
 */
@Data
public class BaseDO implements Serializable {

    /**
     * we can use this annotation to set the primary key about hte table
     */
    @TableId(value = "id",
            type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * is deleted or not
     */
    @TableLogic(value = "0",
            delval = "1")
    private boolean isDeleted;

    /**
     * creator name
     */
    @TableField(value = "creator")
    private String creator;

    /**
     * creator userid
     */
    @TableField(value = "creator_id")
    private Long creatorId;

    /**
     * create time
     */
    private Date gmtCreated;

    /**
     * last operator
     */
    @TableField(value = "last_operator")
    private String lastOperator;

    /**
     * last operatorid
     */
    @TableField(value = "last_operator_id")
    private Long lastOperatorId;

    /**
     * last modify time
     */
    private Date gmtModified;

    /**
     * Is new boolean.
     *
     * @return the boolean
     */
    @Transient
    public boolean isNew() {
        return this.id == null;
    }

//    @Transient
//    @JsonIgnore
//    public void setUpdateInfo(LoginAuthDTO user) {
//        if (isNew()) {
//            this.creatorId = (this.lastOperatorId = user.getUserId());
//            this.creator = user.getLoginName();
//            this.gmtCreated = (this.gmtModified = new Date());
//        }
//        this.lastOperatorId = user.getUserId();
//        this.lastOperator = user.getLoginName() == null ? user.getLoginName() : user.getUserName();
//        this.gmtModified = new Date();
//    }
}

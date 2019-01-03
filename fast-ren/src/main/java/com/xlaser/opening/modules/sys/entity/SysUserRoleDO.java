package com.xlaser.opening.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户与角色对应关系
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.model
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 14:00
 * @description: 用户与角色relation
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRoleDO extends Model<SysUserRoleDO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

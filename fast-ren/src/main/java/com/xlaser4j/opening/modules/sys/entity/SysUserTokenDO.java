package com.xlaser4j.opening.modules.sys.entity;

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
 * 系统用户Token
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.model
 * @author: Elijah.D
 * @time: 2018/10/11 14:00
 * @description: token, 用户关联
 * @modified: Elijah.D
 */
@Data
@TableName("sys_user_token")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserTokenDO extends Model<SysUserTokenDO> {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    @Override
    protected Serializable pkVal() {
        return userId;
    }
}

package com.xlasers.opening.modules.sys.entity;

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
 * 系统配置信息表
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.model
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 13:55
 * @description: 系统配置信息
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
@TableName("sys_config")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysConfigDO extends Model<SysConfigDO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * key
     */
    private String paramKey;

    /**
     * value
     */
    private String paramValue;

    /**
     * 状态   0：隐藏   1：显示
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

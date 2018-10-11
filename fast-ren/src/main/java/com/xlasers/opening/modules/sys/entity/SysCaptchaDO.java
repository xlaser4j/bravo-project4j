package com.xlasers.opening.modules.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统验证码
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.model
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 13:54
 * @description: 验证码
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysCaptchaDO extends Model<SysCaptchaDO> {
    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 获取主键值
     *
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return uuid;
    }
}

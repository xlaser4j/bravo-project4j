package com.xlaser4j.opening.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统验证码
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.model
 * @author: Elijah.D
 * @time: 2018/10/11 13:54
 * @description: 验证码
 * @modified: Elijah.D
 */
@Data
@TableName("sys_captcha")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class SysCaptchaDO extends Model<SysCaptchaDO> {
    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    @TableId(type = IdType.INPUT)
    private String uuid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private Long expireTime;

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

package com.xlasers.opening.common.constants;

/**
 * The type Shiro consts.
 *
 * @package: com.xlasers.opening.common.constants
 * @author: Elijah.D
 * @time: CreateAt 2018/10/15 && 11:19
 * @description: shiro权限相关常量
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public final class ShiroConsts {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * 验证码有效期: 2分钟
     */
    public static final long CAPTCHA_EXPIRY_DATE = 2 * 60 * 1000L;

    private ShiroConsts() {
    }
}

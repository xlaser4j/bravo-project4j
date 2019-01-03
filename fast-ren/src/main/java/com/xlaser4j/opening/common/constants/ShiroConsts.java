package com.xlaser4j.opening.common.constants;

/**
 * <p>
 * C: 权限相关常量
 * </p>
 *
 * @package: com.xlaser4j.opening.common.constants
 * @author: Elijah.D
 * @time: 2018/10/15 11:19
 * @description: shiro常量
 * @modified: Elijah.D
 */
public final class ShiroConsts {
    /**
     * 超级管理员ID
     */
    public static final Long SUPER_ADMIN = 1L;

    /**
     * 验证码有效期: 2分钟
     */
    public static final long CAPTCHA_EXPIRY_DATE = 2 * 60 * 1000L;

    private ShiroConsts() {
    }
}

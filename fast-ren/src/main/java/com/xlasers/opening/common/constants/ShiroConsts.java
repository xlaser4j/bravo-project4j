package com.xlasers.opening.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    public static final Long SUPER_ADMIN = 1L;

    /**
     * 验证码有效期: 2分钟
     */
    public static final long CAPTCHA_EXPIRY_DATE = 2 * 60 * 1000L;

    private ShiroConsts() {
    }

    /**
     * <p> 菜单类型
     */
    @Getter
    @AllArgsConstructor
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private final int value;
    }
}

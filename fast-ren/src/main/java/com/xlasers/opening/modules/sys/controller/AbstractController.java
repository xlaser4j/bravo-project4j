package com.xlasers.opening.modules.sys.controller;

import com.xlasers.opening.modules.sys.entity.SysUserDO;
import org.apache.shiro.SecurityUtils;

/**
 * The type Abstract controller.
 *
 * @package: com.xlasers.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2018/10/16 && 15:36
 * @description: 权限抽象控制
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public abstract class AbstractController {
    /**
     * Gets user.
     *
     * @return the user
     */
    protected SysUserDO getUser() {
        return (SysUserDO) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }
}

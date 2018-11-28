package com.xlasers.opening.modules.sys.controller;

import com.xlasers.opening.modules.sys.entity.SysUserDO;
import org.apache.shiro.SecurityUtils;

/**
 * <p>
 * controller: 通用获取登陆用户信息
 * </p>
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
     * <p> 获取已经登陆用户
     *
     * @return user 用户实体
     */
    protected SysUserDO getUser() {
        return (SysUserDO) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * <p> 获取用户登陆id
     *
     * @return id 用户id
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * <p> 获取用户登陆name
     *
     * @return username 用户名
     */
    protected String getUsername() {
        return getUser().getUsername();
    }
}

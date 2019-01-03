package com.xlaser.opening.modules.sys.service;

import java.util.Set;

import com.xlaser.opening.modules.sys.entity.SysUserDO;
import com.xlaser.opening.modules.sys.entity.SysUserTokenDO;

/**
 * <p>
 * shiro权限 服务类
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:44
 * @description:
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface IShiroService {
    /**
     * List permissions set.
     *
     * @param userId the user id
     * @return the set
     */
    Set<String> listPermissions(long userId);

    /**
     * Get UserToken by token.
     *
     * @param token the token
     * @return the by token
     */
    SysUserTokenDO getUserTokenByToken(String token);

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    SysUserDO getUserById(Long userId);
}

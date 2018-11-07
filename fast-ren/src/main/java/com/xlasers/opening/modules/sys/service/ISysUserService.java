package com.xlasers.opening.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlasers.opening.modules.sys.entity.SysUserDO;

/**
 * <p>
 * service: 用户服务类
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: 用户服务
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface ISysUserService extends IService<SysUserDO> {
    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return user 实体
     */
    SysUserDO getUserByName(String username);
}

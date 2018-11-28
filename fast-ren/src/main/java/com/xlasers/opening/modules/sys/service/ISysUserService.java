package com.xlasers.opening.modules.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlasers.opening.modules.sys.entity.SysUserDO;

/**
 * <p>
 * service: 用户服务
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: 服务类, 用户
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface ISysUserService extends IService<SysUserDO> {
    /**
     * <p> 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return user 实体
     */
    SysUserDO getUserByName(String username);

    /**
     * <p> 获取用户权限id集合
     *
     * @param id 用户id
     * @return list 权限ids
     */
    List<Long> listMenuIdsByUserId(Long id);
}

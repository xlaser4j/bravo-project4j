package com.xlasers.opening.modules.sys.service.impl;

import java.util.Set;

import com.xlasers.opening.modules.sys.entity.SysUserDO;
import com.xlasers.opening.modules.sys.entity.SysUserTokenDO;
import com.xlasers.opening.modules.sys.mapper.SysMenuMapper;
import com.xlasers.opening.modules.sys.mapper.SysUserMapper;
import com.xlasers.opening.modules.sys.mapper.SysUserTokenMapper;
import com.xlasers.opening.modules.sys.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * shiro权限 服务实现类
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:45
 * @description:
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
public class ShiroServiceImpl implements IShiroService {
    private final SysUserMapper userMapper;

    private final SysMenuMapper menuMapper;

    private final SysUserTokenMapper tokenMapper;

    @Autowired
    public ShiroServiceImpl(SysUserMapper userMapper, SysMenuMapper menuMapper, SysUserTokenMapper tokenMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public Set<String> listPermissions(long userId) {
        return null;
    }

    @Override
    public SysUserTokenDO getByToken(String token) {
        return null;
    }

    @Override
    public SysUserDO getUserById(Long userId) {
        return null;
    }
}

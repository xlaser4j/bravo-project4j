package com.xlasers.opening.modules.sys.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import com.xlasers.opening.modules.sys.entity.SysUserDO;
import com.xlasers.opening.modules.sys.entity.SysUserTokenDO;
import com.xlasers.opening.modules.sys.mapper.SysMenuMapper;
import com.xlasers.opening.modules.sys.mapper.SysUserMapper;
import com.xlasers.opening.modules.sys.mapper.SysUserTokenMapper;
import com.xlasers.opening.modules.sys.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xlasers.opening.common.constants.ShiroConsts.SUPER_ADMIN;

/**
 * <p>
 * shiro权限 服务实现类
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:45
 * @description: 权限控制
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
public class ShiroServiceImpl implements IShiroService {
    private final SysUserMapper userMapper;

    private final SysMenuMapper menuMapper;

    private final SysUserTokenMapper tokenMapper;

    /**
     * Instantiates a new Shiro service.
     *
     * @param userMapper  the user mapper
     * @param menuMapper  the menu mapper
     * @param tokenMapper the token mapper
     */
    @Autowired
    public ShiroServiceImpl(SysUserMapper userMapper, SysMenuMapper menuMapper, SysUserTokenMapper tokenMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
        this.tokenMapper = tokenMapper;
    }

    /**
     * 获取用户拥有权限
     *
     * @param userId the user id
     * @return
     */
    @SuppressWarnings("UnstableApiUsage")
    @Override
    public Set<String> listPermissions(long userId) {

        List<String> permList;

        // 超级管理员
        if (userId == SUPER_ADMIN) {
            List<SysMenuDO> menus = menuMapper.selectList(null);
            permList = Lists.newArrayListWithExpectedSize(menus.size());
            menus.forEach(o -> permList.add(o.getPerms()));
        } else {
            permList = menuMapper.listAllPermsByUserId(userId);
        }

        // 权限集合
        Set<String> permSet = new HashSet<>();
        permList.forEach(o -> {
            if (!StrUtil.isBlank(o)) {
                permSet.addAll(Splitter.on(",").trimResults().splitToList(o));
            }
        });

        return permSet;
    }

    /**
     * 获取用户token信息
     *
     * @param token the token
     * @return
     */
    @Override
    public SysUserTokenDO getUserTokenByToken(String token) {
        return tokenMapper.selectUserTokenByToken(token);
    }

    /**
     * 获取用户信息
     *
     * @param userId the user id
     * @return
     */
    @Override
    public SysUserDO getUserById(Long userId) {
        return userMapper.selectById(userId);
    }
}

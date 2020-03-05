package com.xlaser4j.hr.service.impl;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.MenuRoleDO;
import com.xlaser4j.hr.entity.RoleDO;
import com.xlaser4j.hr.mapper.RoleMapper;
import com.xlaser4j.hr.service.IMenuRoleService;
import com.xlaser4j.hr.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {
    private final IMenuRoleService menuRoleService;

    public RoleServiceImpl(IMenuRoleService menuRoleService) {
        this.menuRoleService = menuRoleService;
    }

    /**
     * 编辑角色的权限
     *
     * @param rid     角色id
     * @param menuIds 角色权限id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRoleMenusByRid(Integer rid, Integer[] menuIds) {

        // 先删除,再插入
        menuRoleService.remove(Wrappers.<MenuRoleDO>lambdaQuery().eq(MenuRoleDO::getRid, rid));
        return menuRoleService.saveBatch(Arrays.stream(menuIds).map(o -> new MenuRoleDO().setRid(rid).setMid(o)).collect(Collectors.toList()));
    }
}

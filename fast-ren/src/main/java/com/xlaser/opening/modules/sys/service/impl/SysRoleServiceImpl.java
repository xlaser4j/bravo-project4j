package com.xlaser.opening.modules.sys.service.impl;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser.opening.common.query.PageQuery;
import com.xlaser.opening.common.PageResponse;
import com.xlaser.opening.modules.sys.entity.SysRoleDO;
import com.xlaser.opening.modules.sys.mapper.SysRoleMapper;
import com.xlaser.opening.modules.sys.service.ISysRoleMenuService;
import com.xlaser.opening.modules.sys.service.ISysRoleService;
import com.xlaser.opening.modules.sys.service.ISysUserRoleService;
import com.xlaser.opening.modules.sys.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:43
 * @description:
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleDO> implements ISysRoleService {
    private final ISysRoleMenuService roleMenuService;

    private final ISysUserService userService;

    private final ISysUserRoleService userRoleService;

    /**
     * 分页查询角色列表
     *
     * @param params 请求参数
     * @return page 分页查询内容
     */
    @Override
    public PageResponse listRoles(Map<String, Object> params) {

        String roleName = (String) params.get("roleName");
        String username = (String) params.get("createBy");

        IPage<SysRoleDO> page = page(
                new PageQuery<SysRoleDO>(params).getPage(),
                new QueryWrapper<SysRoleDO>()
                        .eq(username != null, "username", username)
                        .like("roleName", roleName)
        );

        return new PageResponse(page);
    }
}

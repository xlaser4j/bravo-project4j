package com.xlaser4j.opening.modules.sys.service.impl;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.common.query.PageQuery;
import com.xlaser4j.opening.modules.sys.entity.SysRoleDO;
import com.xlaser4j.opening.modules.sys.mapper.SysRoleMapper;
import com.xlaser4j.opening.modules.sys.service.ISysRoleMenuService;
import com.xlaser4j.opening.modules.sys.service.ISysRoleService;
import com.xlaser4j.opening.modules.sys.service.ISysUserRoleService;
import com.xlaser4j.opening.modules.sys.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description:
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

        String roleName = (String)params.get("roleName");
        String username = (String)params.get("createBy");

        IPage<SysRoleDO> page = page(
                new PageQuery<SysRoleDO>(params).getPage(),
                new QueryWrapper<SysRoleDO>()
                        .eq(username != null, "username", username)
                        .like("roleName", roleName)
        );

        return new PageResponse(page);
    }
}

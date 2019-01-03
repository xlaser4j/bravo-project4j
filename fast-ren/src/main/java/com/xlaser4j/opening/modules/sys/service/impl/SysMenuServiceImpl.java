package com.xlaser4j.opening.modules.sys.service.impl;

import java.util.Iterator;
import java.util.List;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.xlaser4j.opening.common.constants.ShiroConsts;
import com.xlaser4j.opening.common.enums.MenuTypeEnum;
import com.xlaser4j.opening.modules.sys.entity.SysMenuDO;
import com.xlaser4j.opening.modules.sys.mapper.SysMenuMapper;
import com.xlaser4j.opening.modules.sys.service.ISysMenuService;
import com.xlaser4j.opening.modules.sys.service.ISysRoleMenuService;
import com.xlaser4j.opening.modules.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * impl: 菜单管理
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description: 服务类, 菜单管理
 * @modified: Elijah.D
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements ISysMenuService {
    private final ISysUserService userService;

    private final ISysRoleMenuService relationService;

    @Autowired
    public SysMenuServiceImpl(ISysUserService userService, ISysRoleMenuService relationService) {
        this.userService = userService;
        this.relationService = relationService;
    }

    /**
     * <p> 根据父级id，查询下级菜单
     *
     * <p> 后续递归构建权限tree时,直接set下级,同时当查询下级不包含下级时,退出递归
     *
     * @param parentId 父菜单ID
     * @param menuIds  用户菜单ID集合 {@code menuIds为null,parentId为0时为管理员权限}
     * @return list 权限集合
     */
    @Override
    public List<SysMenuDO> listSubMenuByParentId(Long parentId, List<Long> menuIds) {
        List<SysMenuDO> subMenus = baseMapper.listMenuByParentId(parentId);
        if (menuIds == null) {
            return subMenus;
        }

        List<SysMenuDO> userMenus = Lists.newArrayListWithExpectedSize(10);
        for (SysMenuDO menu : subMenus) {
            if (menuIds.contains(menu.getMenuId())) {
                userMenus.add(menu);
            }
        }
        return userMenus;
    }

    /**
     * <p> 获取不包含按钮的菜单列表
     *
     * @return list 权限集合
     */
    @Override
    public List<SysMenuDO> listMenuNotButton() {
        return baseMapper.listMenuNotButton();
    }

    /**
     * <p> 获取用户菜单列表
     *
     * @param id 用户id
     * @return list 权限集合
     */
    @Override
    public List<SysMenuDO> listMenuByUserId(Long id) {

        // 管理员权限
        if (ObjectUtil.equal(id, ShiroConsts.SUPER_ADMIN)) {
            return buildAllMenuTree(null);
        }

        // 用户权限
        List<Long> menuIds = userService.listMenuIdsByUserId(id);
        return buildAllMenuTree(menuIds);
    }

    /**
     * <p> 删除权限 {@code 同步删除权限角色关联关系}
     *
     * @param id 权限id
     */
    @Override
    public void deleteById(Long id) {
        removeById(id);
        relationService.removeByMap(Dict.create().set("menu_id", id));
    }

    /**
     * <p> 根据用户id集合,构建权限tree
     *
     * @param ids 拥有id集合
     * @return list 权限tree
     */
    private List<SysMenuDO> buildAllMenuTree(List<Long> ids) {

        List<SysMenuDO> subMenus = listSubMenuByParentId(0L, ids);

        recurseBuildSubTree(subMenus, ids);

        return subMenus;
    }

    /**
     * <p> 递归构建所有子类tree
     *
     * @param menus 父级menu
     * @param ids   用户权限id集合
     * @return list 子类树
     */
    private List<SysMenuDO> recurseBuildSubTree(List<SysMenuDO> menus, List<Long> ids) {

        List<SysMenuDO> subMenus = Lists.newArrayListWithExpectedSize(10);
        Iterator<SysMenuDO> it = menus.iterator();
        while (it.hasNext()) {
            SysMenuDO menu = it.next();
            // 菜单为目录时,进行递归构建tree
            if (ObjectUtil.equal(menu.getMenuId(), MenuTypeEnum.CATALOG.getValue())) {
                menu.setTreeList(recurseBuildSubTree(listSubMenuByParentId(menu.getMenuId(), ids), ids));
            }
            subMenus.add(menu);
        }

        return subMenus;
    }
}

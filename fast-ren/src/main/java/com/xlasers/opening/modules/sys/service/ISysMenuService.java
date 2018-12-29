package com.xlasers.opening.modules.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;

/**
 * <p>
 * service: 菜单管理
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: 服务类, 菜单管理
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface ISysMenuService extends IService<SysMenuDO> {
    /**
     * <p> 根据父级id，查询下级菜单
     *
     * @param parentId 父菜单ID
     * @param menuIds  用户菜单ID集合
     * @return list 权限集合
     */
    List<SysMenuDO> listSubMenuByParentId(Long parentId, List<Long> menuIds);

    /**
     * <p> 获取不包含按钮的菜单列表
     *
     * @return list 权限集合
     */
    List<SysMenuDO> listMenuNotButton();

    /**
     * <p> 获取用户菜单列表
     *
     * @param id 用户id
     * @return list 权限集合
     */
    List<SysMenuDO> listMenuByUserId(Long id);

    /**
     * <p> 删除权限,{@code 同步删除权限角色关联关系}
     *
     * @param id 权限id
     */
    void deleteById(Long id);
}

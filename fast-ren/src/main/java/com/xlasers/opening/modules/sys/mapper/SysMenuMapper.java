package com.xlasers.opening.modules.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import com.xlasers.opening.modules.sys.entity.SysUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 17:00
 * @description: 菜单管理 Mapper
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuDO> {
    /**
     * <p> 根据父级id查询menu实体
     *
     * @param id parentId
     * @return
     */
    List<SysMenuDO> listMenuByParentId(Long id);

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return the list
     */
    List<String> selectAllPermsByUserId(Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId the user id
     * @return the list
     */
    List<Long> selectAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username the username
     * @return the sys user do
     */
    SysUserDO selectByUserName(String username);
}

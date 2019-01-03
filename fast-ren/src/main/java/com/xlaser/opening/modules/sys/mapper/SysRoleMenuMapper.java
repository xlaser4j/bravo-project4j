package com.xlaser.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser.opening.modules.sys.entity.SysRoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 17:00
 * @description: 角色与菜单对应关系 Mapper
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuDO> {
}

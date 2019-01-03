package com.xlaser4j.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysRoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 17:00
 * @description: 角色与菜单对应关系 Mapper
 * @modified: Elijah.D
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuDO> {
}

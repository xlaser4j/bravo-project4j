package com.xlasers.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlasers.opening.modules.sys.entity.SysRoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 17:00
 * @description: 角色 Mapper
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleDO> {
}

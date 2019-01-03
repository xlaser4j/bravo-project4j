package com.xlaser.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser.opening.modules.sys.entity.SysUserRoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与角色对应关系 Mapper 接口
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 17:01
 * @description: 用户与角色对应关系 Mapper
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleDO> {
}

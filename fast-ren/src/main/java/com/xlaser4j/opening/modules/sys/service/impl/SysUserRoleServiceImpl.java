package com.xlaser4j.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.sys.entity.SysUserRoleDO;
import com.xlaser4j.opening.modules.sys.mapper.SysUserRoleMapper;
import com.xlaser4j.opening.modules.sys.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description:
 * @modified: Elijah.D
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleDO> implements ISysUserRoleService {
}

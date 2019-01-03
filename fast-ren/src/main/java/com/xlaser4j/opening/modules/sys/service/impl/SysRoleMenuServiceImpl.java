package com.xlaser4j.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.sys.entity.SysRoleMenuDO;
import com.xlaser4j.opening.modules.sys.mapper.SysRoleMenuMapper;
import com.xlaser4j.opening.modules.sys.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description:
 * @modified: Elijah.D
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuDO> implements ISysRoleMenuService {
}

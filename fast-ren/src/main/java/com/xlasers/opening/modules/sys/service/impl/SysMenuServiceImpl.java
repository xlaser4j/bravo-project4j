package com.xlasers.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import com.xlasers.opening.modules.sys.mapper.SysMenuMapper;
import com.xlasers.opening.modules.sys.service.ISysMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:43
 * @description:
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements ISysMenuService {
}

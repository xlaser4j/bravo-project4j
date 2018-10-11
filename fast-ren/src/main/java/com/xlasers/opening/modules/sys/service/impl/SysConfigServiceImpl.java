package com.xlasers.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlasers.opening.modules.sys.entity.SysConfigDO;
import com.xlasers.opening.modules.sys.mapper.SysConfigMapper;
import com.xlasers.opening.modules.sys.service.ISysConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息表 服务实现类
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
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfigDO> implements ISysConfigService {
}

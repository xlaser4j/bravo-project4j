package com.xlaser.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser.opening.modules.sys.entity.SysLogDO;
import com.xlaser.opening.modules.sys.mapper.SysLogMapper;
import com.xlaser.opening.modules.sys.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:43
 * @description:
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogDO> implements ISysLogService {
}

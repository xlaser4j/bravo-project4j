package com.xlaser4j.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.sys.entity.SysLogDO;
import com.xlaser4j.opening.modules.sys.mapper.SysLogMapper;
import com.xlaser4j.opening.modules.sys.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description:
 * @modified: Elijah.D
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogDO> implements ISysLogService {
}

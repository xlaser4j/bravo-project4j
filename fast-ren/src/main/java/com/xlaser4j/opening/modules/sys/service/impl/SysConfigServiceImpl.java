package com.xlaser4j.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.sys.entity.SysConfigDO;
import com.xlaser4j.opening.modules.sys.mapper.SysConfigMapper;
import com.xlaser4j.opening.modules.sys.service.ISysConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息表 服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description:
 * @modified: Elijah.D
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfigDO> implements ISysConfigService {
}

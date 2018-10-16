package com.xlasers.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlasers.opening.modules.sys.entity.SysLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 16:58
 * @description: 系统日志mapper
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogDO> {
}

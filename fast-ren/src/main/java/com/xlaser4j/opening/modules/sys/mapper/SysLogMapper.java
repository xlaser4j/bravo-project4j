package com.xlaser4j.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 16:58
 * @description: 系统日志mapper
 * @modified: Elijah.D
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogDO> {
}

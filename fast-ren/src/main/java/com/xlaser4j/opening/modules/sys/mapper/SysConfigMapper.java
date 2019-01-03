package com.xlaser4j.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统配置信息表 Mapper 接口
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 16:56
 * @description: 系统信息配置mapper
 * @modified: Elijah.D
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigDO> {
}

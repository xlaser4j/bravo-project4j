package com.xlasers.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlasers.opening.modules.sys.entity.SysConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统配置信息表 Mapper 接口
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 16:56
 * @description: 系统信息配置mapper
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigDO> {
}

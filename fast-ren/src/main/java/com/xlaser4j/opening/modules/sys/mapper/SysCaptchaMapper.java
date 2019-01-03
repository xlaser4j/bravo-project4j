package com.xlaser4j.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysCaptchaDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统验证码 Mapper 接口
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 16:50
 * @description: 系统验证码mapper
 * @modified: Elijah.D
 */
@Mapper
public interface SysCaptchaMapper extends BaseMapper<SysCaptchaDO> {
}

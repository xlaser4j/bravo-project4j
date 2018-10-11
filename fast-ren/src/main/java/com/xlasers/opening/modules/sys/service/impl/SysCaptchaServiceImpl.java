package com.xlasers.opening.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlasers.opening.modules.sys.entity.SysCaptchaDO;
import com.xlasers.opening.modules.sys.mapper.SysCaptchaMapper;
import com.xlasers.opening.modules.sys.service.ISysCaptchaService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统验证码 服务实现类
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
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaMapper, SysCaptchaDO> implements ISysCaptchaService {
}

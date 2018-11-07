package com.xlasers.opening.modules.sys.service;

import java.awt.image.BufferedImage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlasers.opening.modules.sys.entity.SysCaptchaDO;

/**
 * <p>
 * Service: 系统验证码
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: 生成验证码, 校验验证码
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface ISysCaptchaService extends IService<SysCaptchaDO> {
    /**
     * 获取验证码
     *
     * @param uuid 唯一id
     * @return captcha 返回验证码图片
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 校验验证码
     *
     * @param uuid 唯一id
     * @param code 验证码
     * @return 成功:{@code true} or 失败:{@code false}
     */
    boolean validate(String uuid, String code);
}

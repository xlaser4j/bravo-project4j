package com.xlaser4j.opening.modules.sys.service.impl;

import java.awt.image.BufferedImage;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import com.xlaser4j.opening.common.constants.ShiroConsts;
import com.xlaser4j.opening.common.enums.Status;
import com.xlaser4j.opening.common.exception.FastRenException;
import com.xlaser4j.opening.modules.sys.entity.SysCaptchaDO;
import com.xlaser4j.opening.modules.sys.mapper.SysCaptchaMapper;
import com.xlaser4j.opening.modules.sys.service.ISysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Impl: 系统验证码
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description: 验证码实现类
 * @modified: Elijah.D
 */
@Service
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaMapper, SysCaptchaDO> implements ISysCaptchaService {
    private final Producer producer;

    @Autowired
    public SysCaptchaServiceImpl(Producer producer) {
        this.producer = producer;
    }

    /**
     * 获取验证码
     *
     * @param uuid 唯一id
     * @return captcha 返回验证码图片
     */
    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StrUtil.isBlank(uuid)) {
            throw new FastRenException(Status.CAPTCHA_UUID_NOT_NULL);
        }

        // 生成验证码
        String code = producer.createText();
        BufferedImage image = producer.createImage(code);

        // 保存验证码
        SysCaptchaDO captcha = new SysCaptchaDO(uuid, code, System.currentTimeMillis() + ShiroConsts.CAPTCHA_EXPIRY_DATE);
        save(captcha);

        return image;
    }

    /**
     * 校验验证码
     *
     * @param uuid 唯一id
     * @param code 验证码
     * @return 成功 {@code true} or 失败 {@code false}
     */
    @Override
    public boolean validate(String uuid, String code) {

        // 查询是否生成验证码
        SysCaptchaDO captcha = getOne(new QueryWrapper<SysCaptchaDO>().eq("uuid", uuid));
        if (captcha == null) {
            return false;
        }

        // 只要存在,证明验证一次,删除
        removeById(uuid);

        //验证失败重新,生成验证
        return StrUtil.equals(captcha.getCode(), code) && captcha.getExpireTime() > System.currentTimeMillis();
    }
}

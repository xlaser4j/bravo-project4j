package com.xlasers.opening.modules.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.StrUtil;
import com.xlasers.opening.common.ApiResponse;
import com.xlasers.opening.common.enums.Status;
import com.xlasers.opening.common.exception.FastRenException;
import com.xlasers.opening.modules.sys.entity.SysUserDO;
import com.xlasers.opening.modules.sys.form.LoginForm;
import com.xlasers.opening.modules.sys.service.ISysCaptchaService;
import com.xlasers.opening.modules.sys.service.ISysUserService;
import com.xlasers.opening.modules.sys.service.ISysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.xlasers.opening.common.enums.Status.ACCOUNT_NOT_MATCH;
import static com.xlasers.opening.common.enums.Status.CAPTCHA_NOT_MATCH;

/**
 * <p>
 * controller: 登陆控制器
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2018/10/16 && 15:36
 * @description: 登陆控制
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@RestController
public class SysLoginController extends AbstractController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysCaptchaService captchaService;

    @Autowired
    private ISysUserTokenService userTokenService;

    /**
     * 获取验证码
     *
     * @param res  response
     * @param uuid 验证码唯一id
     * @throws IOException
     */
    @GetMapping("captcha.jpg")
    public void getCaptcha(HttpServletResponse res, String uuid) throws IOException {
        res.setHeader("Cache-Control", "no-store, no-cache");
        res.setContentType("image/jpeg");

        BufferedImage image = captchaService.getCaptcha(uuid);
        ServletOutputStream stream = res.getOutputStream();
        ImageUtil.write(image, "jpg", stream);

        IoUtil.close(stream);
    }

    /**
     * 登陆验证
     *
     * @param form 登陆表单{@link LoginForm}
     * @return res
     */
    @PostMapping("/sys/login")
    public ApiResponse login(@RequestBody LoginForm form) {
        boolean flag = captchaService.validate(form.getUuid(), form.getCaptcha());
        if (flag) {
            throw new FastRenException(CAPTCHA_NOT_MATCH);
        }

        SysUserDO user = userService.getUserByName(form.getUsername());
        if (user == null || StrUtil.equals(user.getPassword(),new Sha256Hash(form.getPassword(),user.getSalt()).toHex())) {
            throw new FastRenException(ACCOUNT_NOT_MATCH);
        }

        return null;
    }
}

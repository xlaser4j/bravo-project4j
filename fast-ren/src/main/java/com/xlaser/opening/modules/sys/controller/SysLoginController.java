package com.xlaser.opening.modules.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.StrUtil;
import com.xlaser.opening.common.ApiResponse;
import com.xlaser.opening.common.exception.FastRenException;
import com.xlaser.opening.modules.sys.entity.SysUserDO;
import com.xlaser.opening.modules.sys.form.LoginForm;
import com.xlaser.opening.modules.sys.service.ISysCaptchaService;
import com.xlaser.opening.modules.sys.service.ISysUserService;
import com.xlaser.opening.modules.sys.service.ISysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.xlaser.opening.common.enums.Status.*;

/**
 * <p>
 * controller: 登陆控制器
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2018/10/16 && 15:36
 * @description: 登陆控制
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@RestController
public class SysLoginController extends AbstractController {
    private final ISysUserService userService;

    private final ISysCaptchaService captchaService;

    private final ISysUserTokenService userTokenService;

    @Autowired
    public SysLoginController(ISysUserService userService, ISysCaptchaService captchaService, ISysUserTokenService userTokenService) {
        this.userService = userService;
        this.captchaService = captchaService;
        this.userTokenService = userTokenService;
    }

    /**
     * <p> 获取验证码
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
     * <p> 登陆验证
     *
     * @param form 登陆表单{@link LoginForm}
     * @return res
     */
    @PostMapping("/sys/login")
    public ApiResponse login(@RequestBody LoginForm form) {

        // 验证码
        boolean flag = captchaService.validate(form.getUuid(), form.getCaptcha());
        if (flag) {
            throw new FastRenException(CAPTCHA_NOT_MATCH);
        }

        // 账号密码
        SysUserDO user = userService.getUserByName(form.getUsername());
        if (user == null || StrUtil.equals(user.getPassword(), new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            throw new FastRenException(ACCOUNT_NOT_MATCH);
        }

        // 状态
        if (user.getStatus() == 0) {
            throw new FastRenException(STATUS_LOCKED);
        }

        return userTokenService.createToken(user.getUserId());
    }

    /**
     * <p> 登陆退出,修改token值
     */
    @PostMapping("/sys/logout")
    public ApiResponse logout() {

        userTokenService.updateToken(getUserId());

        return ApiResponse.ofSuccess();
    }
}

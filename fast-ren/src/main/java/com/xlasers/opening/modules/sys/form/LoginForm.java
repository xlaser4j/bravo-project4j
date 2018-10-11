package com.xlasers.opening.modules.sys.form;

import lombok.Data;

/**
 * The type Login form.
 *
 * @package: com.xlasers.opening.modules.sys.form
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 20:15
 * @description: 登录表单
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
public class LoginForm {
    /**
     * The Username.
     */
    private String username;

    /**
     * The Password.
     */
    private String password;

    /**
     * The Captcha.
     */
    private String captcha;

    /**
     * The Uuid.
     */
    private String uuid;
}

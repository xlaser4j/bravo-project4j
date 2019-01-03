package com.xlaser.opening.modules.sys.form;

import lombok.Data;

/**
 * <p>
 * form: 登陆表单
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.form
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 20:15
 * @description: 登录表单
 * @copyright: Copyright © 2018 xlaser
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

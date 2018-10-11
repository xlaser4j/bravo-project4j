package com.xlasers.opening.modules.sys.form;

import lombok.Data;

/**
 * The type Pwd form.
 *
 * @package: com.xlasers.opening.modules.sys.form
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 20:15
 * @description: 密码表单
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
public class PwdForm {
    /**
     * 原密码
     */
    private String oldPwd;

    /**
     * 新密码
     */
    private String newPwd;
}

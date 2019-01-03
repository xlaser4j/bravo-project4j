package com.xlaser4j.opening.modules.sys.form;

import lombok.Data;

/**
 * The type Pwd form.
 *
 * @package: com.xlaser4j.opening.modules.sys.form
 * @author: Elijah.D
 * @time: 2018/10/11 20:15
 * @description: 密码表单
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

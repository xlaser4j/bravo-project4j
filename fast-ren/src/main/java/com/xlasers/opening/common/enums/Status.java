package com.xlasers.opening.common.enums;

import lombok.Getter;

/**
 * The enum Status.
 *
 * @package: com.xlasers.opening.common.enums
 * @author: Elijah.D
 * @time: CreateAt 2018/10/15 && 16:48
 * @description: 状态码封装
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Getter
public enum Status {

    /**
     * 操作成功
     */
    OK(200, "操作成功 !"),

    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误 !"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401, "无效token,验证失败 !"),

    /**
     * 请求不存在
     */
    REQUEST_NOT_FOUND(404, "请求不存在 !"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错啦 !"),

    /**
     * 参数不匹配
     */
    PARAM_NOT_MATCH(4000, "参数不匹配 !"),

    /**
     * 请求参数不能为空
     */
    PARAM_NOT_NULL(4001, "请求参数不能为空 !"),

    /**
     * 生成Token失败
     */
    FAILED_CREATE_TOKEN(-1000, "生成Token失败 !"),

    /**
     * 获取验证码uuid为空
     */
    CAPTCHA_UUID_NOT_NULL(-1001, "获取验证码,uuid为不能为空 !"),

    /**
     * 验证码不正确
     */
    CAPTCHA_NOT_MATCH(-1002, "错误 ! 验证码不正确 !"),

    /**
     * 账号密码不匹配
     */
    ACCOUNT_NOT_MATCH(-1003, "错误 ! 账号或密码不正确 !");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 内容
     */
    private final String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

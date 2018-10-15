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
    OK(200, "操作成功"),

    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401,"无效token,验证失败 !"),

    /**
     * 请求不存在
     */
    REQUEST_NOT_FOUND(404, "请求不存在"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错啦"),

    /**
     * 参数不匹配
     */
    PARAM_NOT_MATCH(4000, "参数不匹配"),

    /**
     * 请求参数不能为空
     */
    PARAM_NOT_NULL(4000, "请求参数不能为空"),

    /**
     * 生成Token失败
     */
    FAILED_CREATE_TOKEN(-1000,"生成Token失败");

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

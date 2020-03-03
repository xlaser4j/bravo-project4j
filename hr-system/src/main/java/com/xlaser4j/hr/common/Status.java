package com.xlaser4j.hr.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @package: com.xlaser4j.hr.common
 * @author: Elijah.D
 * @time: 2020/2/10 15:25
 * @description: 状态码封装
 * @modified: Elijah.D
 */
@Getter
public enum Status {
    /**
     * 操作成功
     */
    OK(HttpStatus.OK),

    /**
     * 未登陆
     */
    NO_LOGIN(HttpStatus.BAD_REQUEST, "请登录!"),

    /**
     * 登陆成功
     */
    LOGIN(HttpStatus.OK, "登陆成功!"),

    /**
     * 注销成功
     */
    LOGOUT(HttpStatus.OK, "注销成功!"),

    /**
     * 请求错误
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST),

    /**
     * 参数不匹配
     */
    PARAM_NOT_MATCH(HttpStatus.BAD_REQUEST, "参数不匹配!"),

    /**
     * 请求参数不能为空
     */
    PARAM_NOT_NULL(HttpStatus.BAD_REQUEST, "请求参数不能为空!"),

    /**
     * 未授权
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),

    /**
     * 请求不存在
     */
    REQUEST_NOT_FOUND(HttpStatus.NOT_FOUND),

    /**
     * 数据库主外键/唯一约束异常
     */
    SQL_CONSTRAINT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "数据操作异常,存在关联数据!"),

    /**
     * 数据库异常
     */
    SQL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "数据库异常!"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * 自定义状态码和消息
     */
    CUSTOM_ERROR(-1000, "自定义状态码和消息");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 内容
     */
    private final String message;

    Status(HttpStatus status) {
        code = status.value();
        message = status.getReasonPhrase();
    }

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    Status(HttpStatus status, String message) {
        code = status.value();
        this.message = message;
    }
}

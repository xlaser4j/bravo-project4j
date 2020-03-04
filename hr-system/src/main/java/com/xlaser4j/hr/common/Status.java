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
    // -------- 前端统一处理拦截,当后端返回有message时,前端就需要提示弹窗,否则不提示弹窗

    /**
     * 成功,无消息
     */
    OK(HttpStatus.OK, null),

    /**
     * 登陆成功
     */
    LOGIN(HttpStatus.OK, null),

    /**
     * 未登陆
     */
    NO_LOGIN(HttpStatus.BAD_REQUEST, "请登录!"),

    /**
     * 注销成功
     */
    LOGOUT(HttpStatus.OK, "注销成功!"),

    /**
     * 新增成功
     */
    SAVE_SUCCESS(HttpStatus.OK, "新增成功!"),

    /**
     * 新增失败
     */
    SAVE_FAIL(HttpStatus.OK, "新增失败!"),

    /**
     * 更新成功
     */
    UPDATE_SUCCESS(HttpStatus.OK, "更新成功!"),

    /**
     * 更新失败
     */
    UPDATE_FAIL(HttpStatus.OK, "更新失败!"),

    /**
     * 删除成功
     */
    DELETE_SUCCESS(HttpStatus.OK, "删除成功!"),

    /**
     * 删除失败
     */
    DELETE_FAIL(HttpStatus.OK, "删除失败!"),

    /**
     * 操作失败: 当一个操作需要失败的原因有很多,需要{@link ApiResponse#ofFail}自定义构建
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, null),

    /**
     * 参数不匹配
     */
    PARAM_NOT_MATCH(HttpStatus.BAD_REQUEST, "参数不匹配!"),

    /**
     * 请求参数不能为空
     */
    PARAM_NOT_NULL(HttpStatus.BAD_REQUEST, "请求参数不能为空!"),

    /**
     * 请求不存在
     */
    REQUEST_NOT_FOUND(HttpStatus.NOT_FOUND, "请求不存在!"),

    /**
     * 数据库主外键/唯一约束异常
     */
    SQL_CONSTRAINT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "数据操作异常,存在关联数据或约束限制!"),

    /**
     * 数据库异常
     */
    SQL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "数据库异常!"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "服务器内部错误!"),

    /**
     * 自定义状态码和消息
     */
    CUSTOM_ERROR(-1000, "自定义状态码和消息");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 消息
     */
    private final String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    Status(HttpStatus status, String message) {
        code = status.value();
        this.message = message;
    }
}

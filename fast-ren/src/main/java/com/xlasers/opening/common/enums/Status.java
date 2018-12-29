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
    ACCOUNT_NOT_MATCH(-1003, "错误 ! 账号或密码不正确 !"),

    /**
     * 状态锁定
     */
    STATUS_LOCKED(-1004, "错误 ! 状态已锁定,请联系管理员 !"),

    /**
     * 所有系统菜单,禁止删除
     */
    DELETE_SYS_MENU_ERROR(-1005, "错误 ! 系统菜单,禁止删除 !"),

    /**
     * 存在下级菜单,请先删除子菜单
     */
    DELETE_PARENT_MENU_ERROR(-1006, "错误 ! 存在下级菜单,请先删除子菜单 !"),

    /**
     * 菜单类型必须包含url
     */
    OPERATE_MENU_ERROR(-1006, "错误 ! 菜单类型必须包含url !"),

    /**
     * 菜单类型上级类型只能为目录,按钮上级只能为菜单
     */
    PARENT_TYPE_ERROR(-1006, "错误 ! 父级类型错误: 目录 - 菜单 - 按钮 !"),

    /**
     * sql包含非法字符
     */
    ILLEGAL_SQL_WORDS(-2000, "错误 ! 存在非法sql字符,会造成sql注入风险, !");

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

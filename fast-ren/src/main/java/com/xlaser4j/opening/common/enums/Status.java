package com.xlaser4j.opening.common.enums;

import lombok.Getter;

/**
 * The enum Status.
 *
 * @package: com.xlaser4j.opening.common.enums
 * @author: Elijah.D
 * @time: 2018/10/15 16:48
 * @description: 状态码封装
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
    ILLEGAL_SQL_WORDS(-2000, "错误 ! 存在非法sql字符,会造成sql注入风险, !"),

    /**
     * 定时任务执行失败
     */
    SCHEDULE_JOB_FAILED(-3000, "异常 ! 定时任务执行失败 !"),

    /**
     * 获取cron触发器失败
     */
    GET_TRIGGER_FAILED(-3001, "异常 ! 获取定时任务CronTrigger失败 !"),

    /**
     * 创建定时任务失败
     */
    CREATE_JOB_FAILED(-3002, "异常 ! 创建定时任务失败 !"),

    /**
     * 更新定时任务失败
     */
    UPDATE_JOB_FAILED(-3003, "异常 ! 更新定时任务失败 !"),

    /**
     * 删除定时任务失败
     */
    DELETE_JOB_FAILED(-3004, "异常 ! 删除定时任务失败 !"),

    /**
     * 启动定时任务失败
     */
    START_JOB_FAILED(-3005, "异常 ! 启动定时任务失败 !"),

    /**
     * 暂停定时任务失败
     */
    PAUSE_JOB_FAILED(-3006, "异常 ! 暂停定时任务失败 !"),

    /**
     * 恢复定时任务失败
     */
    RESUME_JOB_FAILED(-3007, "异常 ! 恢复定时任务失败 !");

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

package com.xlaser4j.hr.common;

import com.xlaser4j.hr.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @package: com.xlaser4j.common
 * @author: Elijah.D
 * @time: 2020/2/10 15:18
 * @description:
 * @modified: Elijah.D
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * <p> 构造一个成功无返回数据的API返回
     *
     * @return ApiResponse api返回
     */
    public ApiResponse<T> ofSuccess() {
        return ofStatus(Status.OK);
    }

    /**
     * <p> 构造一个成功且带数据的API返回
     *
     * @param data 返回数据
     * @return ApiResponse api返回
     */
    public ApiResponse<T> ofSuccess(T data) {
        return ofStatus(Status.OK, data);
    }

    /**
     * 构造一个失败的API返回
     * <p>
     * 当错误原因需要枚举的时候使用,正常的错误/成功提示使用status枚举
     *
     * @param message 返回消息
     * @return ApiResponse api返回
     */
    public ApiResponse<T> ofFail(String message) {
        return of(Status.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * <p> 构造一个有状态的API返回
     *
     * @param status 状态 {@link Status}
     * @return ApiResponse api返回
     */
    public ApiResponse<T> ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * <p> 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link Status}
     * @param data   返回数据
     * @return ApiResponse api返回
     */
    public ApiResponse<T> ofStatus(Status status, T data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * <p> 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回消息
     * @param data    返回数据
     * @return ApiResponse api返回
     */
    public ApiResponse<T> of(Integer code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

    /**
     * <p> 构造一个异常的API返回
     *
     * @param <E> {@link com.xlaser4j.hr.exception.BaseException} 的子类
     * @param t   异常
     * @return ApiResponse api返回
     */
    @SuppressWarnings("unchecked")
    public <E extends BaseException> ApiResponse<T> ofException(E t) {
        return of(t.getCode(), t.getMessage(), (T)t.getData());
    }
}

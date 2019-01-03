package com.xlaser.opening.common.exception;

import com.xlaser.opening.common.ApiResponse;
import com.xlaser.opening.common.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * The type Fast ren exception handler.
 *
 * @package: com.xlaser.opening.common.exception
 * @author: Elijah.D
 * @time: CreateAt 2018/10/15 && 16:52
 * @description: 统一异常处理
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
@ControllerAdvice
public class FastRenExceptionHandler {
    /**
     * Handler exception api response.
     *
     * @param e the e
     * @return the api response
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse handlerException(Exception e) {
        if (e instanceof NoHandlerFoundException) {

            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法 {}, 请求路径 {}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return ApiResponse.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof MethodArgumentNotValidException) {

            log.error("【全局异常拦截】MethodArgumentNotValidException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage(), null);
        } else if (e instanceof MethodArgumentTypeMismatchException) {

            log.error("【全局异常拦截】MethodArgumentTypeMismatchException: 参数名 {}, 异常信息 {}", ((MethodArgumentTypeMismatchException) e).getName(), ((MethodArgumentTypeMismatchException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {

            log.error("【全局异常拦截】HttpMessageNotReadableException: 错误信息 {}", ((HttpMessageNotReadableException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_NULL);
        } else if (e instanceof FastRenException) {

            log.error("【全局异常拦截】FastRenException: 状态码 {}, 异常信息 {}", ((FastRenException) e).getCode(), e.getMessage());
            return ApiResponse.ofException((FastRenException) e);
        }

        log.error("【全局异常拦截】: 异常信息 {} ", e.getMessage());
        return ApiResponse.ofStatus(Status.UNKNOWN_ERROR);
    }
}

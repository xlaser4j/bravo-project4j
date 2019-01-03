package com.xlaser4j.opening.common.exception;

import com.xlaser4j.opening.common.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Base exception.
 *
 * @package: com.xlaser4j.opening.common.exception
 * @author: Elijah.D
 * @time: 2018/10/15 16:46
 * @description: 异常基类
 * @modified: Elijah.D
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 3903606557699184213L;

    /**
     * The Code.
     */
    private Integer code;

    /**
     * The Message.
     */
    private String message;

    /**
     * The Data.
     */
    private Object data;

    /**
     * Instantiates a new Base exception.
     *
     * @param status the status
     */
    public BaseException(Status status) {
        super(status.getMessage());
        code = status.getCode();
        message = status.getMessage();
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param status the status
     * @param data   the data
     */
    public BaseException(Status status, Object data) {
        this(status);
        this.data = data;
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param code    the code
     * @param message the message
     */
    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param code    the code
     * @param message the message
     * @param data    the data
     */
    public BaseException(Integer code, String message, Object data) {
        this(code, message);
        this.data = data;
    }
}

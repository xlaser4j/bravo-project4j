package com.xlaser4j.hr.exception;

import com.xlaser4j.hr.common.Status;
import lombok.Getter;

/**
 * @package: com.xlaser4j.hr.exception
 * @author: Elijah.D
 * @time: 2020/2/10 18:56
 * @description: 全局异常
 * @modified: Elijah.D
 */
@Getter
public class ApiException extends BaseException {
    private static final long serialVersionUID = 4416534944049067407L;

    /**
     * Instantiates exception.
     *
     * @param status
     */
    public ApiException(Status status) {
        super(status);
    }

    /**
     * Instantiates exception.
     *
     * @param status
     * @param data
     */
    public ApiException(Status status, Object data) {
        super(status, data);
    }

    /**
     * Instantiates exception.
     *
     * @param code
     * @param message
     */
    public ApiException(Integer code, String message) {
        super(code, message);
    }

    /**
     * Instantiates exception.
     *
     * @param code
     * @param message
     * @param data
     */
    public ApiException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}

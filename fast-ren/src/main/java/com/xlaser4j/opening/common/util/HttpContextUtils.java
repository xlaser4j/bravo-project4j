package com.xlaser4j.opening.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The type Http context utils.
 *
 * @package: com.xlaser4j.opening.common.util
 * @author: Elijah.D
 * @time: 2018/10/15 17:14
 * @description: http全局相关工具类
 * @modified: Elijah.D
 */
public class HttpContextUtils {
    private HttpContextUtils() {
    }

    /**
     * Gets http servlet request.
     *
     * @return the http servlet request
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * Get domain string.
     *
     * @return the string
     */
    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    /**
     * Get origin string.
     *
     * @return the string
     */
    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader("Origin");
    }
}

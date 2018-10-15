package com.xlasers.opening.modules.sys.oauth2;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.xlasers.opening.common.ApiResponse;
import com.xlasers.opening.common.util.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.xlasers.opening.common.enums.Status.UNAUTHORIZED;

/**
 * The type Oauth filter.
 *
 * @package: com.xlasers.opening.modules.sys.oauth2
 * @author: Elijah.D
 * @time: CreateAt 2018/10/15 && 15:40
 * @description: 权限过滤器
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class OauthFilter extends AuthenticatingFilter {
    /**
     * Gets request token.
     *
     * <p>获取请求的token</p>
     *
     * @param httpRequest the http request
     * @return the request token
     */
    public static String getRequestToken(HttpServletRequest httpRequest) {

        // 从header中获取token
        String token = httpRequest.getHeader("token");

        // 如果header中不存在token，则从参数中获取token
        if (StrUtil.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }

        return token;
    }

    /**
     * 生成token
     *
     * <p> 用于后续 {@link AuthenticatingFilter#executeLogin}执行
     *
     * @param req
     * @param res
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest req, ServletResponse res) {

        // 获取请求中的token
        String token = getRequestToken((HttpServletRequest) req);
        if (StrUtil.isBlank(token)) {
            return null;
        }

        return new OauthToken(token);
    }

    /**
     * 表示是否允许访问
     *
     * <p> 如果允许访问返回true，否则false；
     *
     * <p> {@link RequestMethod#OPTIONS}
     *
     * <p> 触发预检查的请求: TODO
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return ((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name());
    }

    /**
     * 表示当访问拒绝时是否已经处理
     *
     * <p> 如果返回true表示需要继续处理；
     *
     * <p> 如果返回false表示该拦截器实例已经处理直接返回;
     *
     * @param req
     * @param res
     * @return
     * @throws IOException
     */
    @SuppressWarnings("DanglingJavadoc")
    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse res) throws Exception {

        // 获取token,验证失败直接返回错误信息
        String token = getRequestToken((HttpServletRequest) req);
        if (StrUtil.isBlank(token)) {

            HttpServletResponse httpServletResponse = (HttpServletResponse) res;
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

            String jsonMsg = new Gson().toJson(ApiResponse.ofStatus(UNAUTHORIZED));
            httpServletResponse.getWriter().print(jsonMsg);
            return false;
        }

        /**
         * 执行登陆,此处用到{@link OauthToken}
         *
         * @see OauthFilter#createToken
         */
        return executeLogin(req, res);
    }

    /**
     * 登陆验证失败,返回响应信息
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

        // 处理登录失败
        Throwable t = e.getCause() == null ? e : e.getCause();
        String jsonMsg = new Gson().toJson(ApiResponse.of(UNAUTHORIZED.getCode(), t.getMessage(), null));
        try {
            httpResponse.getWriter().print(jsonMsg);
        } catch (IOException e1) {
            log.error("【OauthFilter】io异常,输出响应信息失败 !");
        }

        return false;
    }
}

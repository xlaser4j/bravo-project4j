package com.xlaser4j.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.common.Status;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.xlaser4j.hr.controller
 * @author: Elijah.D
 * @time: 2/19/2020 10:28 PM
 * @description:
 * @modified: Elijah.D
 */
@RestController
public class LoginController {
    /**
     * 前端后端分离,登陆页返回json
     * <p>
     * 前端访问后端时如果没有登陆,security就会默认跳转至这个路径,相当于去登陆页面,因此,即使前端已经配置node跨域,
     * 但是如果前端直接未登陆去访问后端接口,浏览器console就会报错发出跨域问题: No 'Access-Control-Allow-Origin'
     * header is present on the requested resource.
     * <p>
     * Access to XMLHttpRequest at 'http://localhost:8081/login' (redirected from 'http://localhost:8080/sys/menus')
     * from origin 'http://localhost:8080' has been blocked by CORS policy:
     * <p>
     * 假如随便打开一个前端vue页面,因为要加载菜单,所以请求接口sys/menus到后端,但是security发现没有登陆,返回前端登录页
     * 的路径/login, 但是返回的端口时8081,浏览器这是前端的端口时8080会自动重定向请求8081/login的路径,这个时候就出现
     * 了跨域问题,因为这个重定向路径并没有经过前端的node代理,是浏览器直接发出的请求,所以跨域
     * <p>
     * 1.CrossOrigin("*"): 可以在接口上直接添加注解,或者添加配置等实现跨域
     * 2.默认是重定向{@link LoginUrlAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     * 因此还可以修改Security中的exceptionHandling配置,自定义authenticationEntryPoint处理,当出现未登录请求/权限
     * 不足时: Full authentication is required to access this resource,直接返回前端错误数据
     *
     * @return msg
     */
    @GetMapping("/login")
    public ApiResponse<Object> login() {
        return new ApiResponse<>().ofStatus(Status.NO_LOGIN);
    }
}

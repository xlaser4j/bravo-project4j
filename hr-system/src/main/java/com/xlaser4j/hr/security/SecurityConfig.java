package com.xlaser4j.hr.security;

import cn.hutool.extra.servlet.ServletUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.controller.LoginController;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.service.IHrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import static com.xlaser4j.hr.common.Status.LOGIN;
import static com.xlaser4j.hr.common.Status.LOGOUT;

/**
 * @package: com.xlaser4j.hr.config
 * @author: Elijah.D
 * @time: 2020/2/9 22:35
 * @description: security配置(详细注释参见github - spring - demo4j)
 * @modified: Elijah.D
 */
@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final IHrService hrService;

    private final CustomDecisionManager decisionManager;

    private final CustomSecurityFilterMetadata securityFilter;

    public SecurityConfig(IHrService hrService, CustomDecisionManager decisionManager, CustomSecurityFilterMetadata securityFilter) {
        this.hrService = hrService;
        this.decisionManager = decisionManager;
        this.securityFilter = securityFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    /**
     * 注意exceptionHandling().authenticationEntryPoint(point)的处理逻辑{@link LoginController#login()}
     *
     * @param http security
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 权限处理逻辑
        ObjectPostProcessor<FilterSecurityInterceptor> processor = new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(securityFilter);
                o.setAccessDecisionManager(decisionManager);
                return o;
            }
        };
        // 登陆成功处理
        AuthenticationSuccessHandler successHandler = (req, res, auth) -> {
            HrDO principal = (HrDO)auth.getPrincipal();
            principal.setPassword(null);
            ApiResponse<Object> response = new ApiResponse<>().ofStatus(LOGIN, principal);
            String data = new ObjectMapper().writeValueAsString(response);
            ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
        };
        // 登陆失败处理
        AuthenticationFailureHandler failureHandler = (req, res, e) -> {
            String errorMsg = "登陆失败!";
            if (e instanceof BadCredentialsException) {
                errorMsg = "账号或密码输入错误!";
            }
            if (e instanceof DisabledException) {
                errorMsg = "账户被禁用!";
            }
            if (e instanceof CredentialsExpiredException) {
                errorMsg = "密码过期!";
            }
            if (e instanceof AccountExpiredException) {
                errorMsg = "账号过期!";
            }
            if (e instanceof LockedException) {
                errorMsg = "账号被锁定!";
            }
            log.error("[全局异常拦截]AuthenticationException: 登陆失败! 异常信息: ", e);
            String data = new ObjectMapper().writeValueAsString(new ApiResponse<>().ofMessage(errorMsg));
            ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
        };
        // 注销成功处理
        LogoutSuccessHandler logoutSuccessHandler = (req, res, auth) -> {
            ApiResponse<Object> response = new ApiResponse<>().ofStatus(LOGOUT);
            String data = new ObjectMapper().writeValueAsString(response);
            ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
        };
        // 请求异常或者权限不足处理(eg:前端非登录直接请求,前端也应该做判断用户如没有登陆,禁止直接访问页面,直接跳转到登陆页)
        AuthenticationEntryPoint point = (req, res, e) -> {
            String errorMsg = "请求失败!";
            // 未登陆也即是权限不足: Full authentication is required to access this resource
            if (e instanceof InsufficientAuthenticationException) {
                errorMsg = "权限不足,请联系管理员!";
            }
            String data = new ObjectMapper().writeValueAsString(new ApiResponse<>().ofMessage(errorMsg));
            ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
        };
        // 认证处理逻辑配置
        http.authorizeRequests()
                /// .anyRequest().authenticated()
                .withObjectPostProcessor(processor)
                .and()
                .formLogin().loginProcessingUrl("/doLogin").loginPage("/login")
                .successHandler(successHandler).failureHandler(failureHandler).permitAll()
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .csrf().disable()
                // 前端如果没有登陆直接发起请求时(浏览器中直接访问组件),默认直接重定向到loginPage也就是后端的/login
                // 路径,浏览器的得到响应就是重定向到8081:/login,这个时候浏览器(前端8080)会直接请求,出现跨域问题,页面
                // 得不到任何提示(可以在login接口中添加crossOrigin允许跨域),也可也这里直接返回错误信息
                // 默认处理: LoginUrlAuthenticationEntryPoint#commence()
                .exceptionHandling().authenticationEntryPoint(point);
    }

    /**
     * 因为postProcessor中配置了拦截器{@link CustomSecurityFilterMetadata}会拦截所有路径,因此当未登陆发起请求时
     * 默认是跳转到loginPage中配置的/login路径,这里需要是忽略这个拦截,否则陷入死循环,需要登陆才能发请求,但是前后端分离,
     * 后端没有登陆page,/login只是返回json数据,如果拦截这个login将看不到'请登陆的提示'
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/login");
    }
}

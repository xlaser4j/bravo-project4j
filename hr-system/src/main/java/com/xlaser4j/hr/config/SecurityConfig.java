package com.xlaser4j.hr.config;

import cn.hutool.extra.servlet.ServletUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.service.IHrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.xlaser4j.hr.common.Status.LOGIN;
import static com.xlaser4j.hr.common.Status.LOGOUT;

/**
 * @package: com.xlaser4j.hr.config
 * @author: Elijah.D
 * @time: 2020/2/9 22:35
 * @description:
 * @modified: Elijah.D
 */
@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final IHrService hrService;

    public SecurityConfig(IHrService hrService) {
        this.hrService = hrService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler((req, res, auth) -> {
                    HrDO principal = (HrDO)auth.getPrincipal();
                    principal.setPassword(null);
                    ApiResponse<Object> response = new ApiResponse<>().ofStatus(LOGIN, principal);
                    String data = new ObjectMapper().writeValueAsString(response);
                    ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
                })
                .failureHandler((req, res, e) -> {
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
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((req, res, auth) -> {
                    ApiResponse<Object> response = new ApiResponse<>().ofStatus(LOGOUT);
                    String data = new ObjectMapper().writeValueAsString(response);
                    ServletUtil.write(res, data, MediaType.APPLICATION_JSON_UTF8_VALUE);
                })
                .and().csrf().disable();
    }
}

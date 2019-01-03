package com.xlaser4j.opening.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * The type Filter config.
 *
 * @package: com.xlaser4j.opening.config
 * @author: Elijah.D
 * @time: 2018/10/22 23:31
 * @description: 过滤器配置
 * @modified: Elijah.D
 */
@Configuration
public class FilterConfig {
    /**
     * Shiro filter
     *
     * @return shiro 过滤
     */
    @Bean
    public FilterRegistrationBean shiroFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        // false: 生命周期SpringApplicationContext管理，true: ServletContainer管理
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
        return registration;
    }
}

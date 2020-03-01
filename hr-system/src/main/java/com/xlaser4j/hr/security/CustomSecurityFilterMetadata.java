package com.xlaser4j.hr.security;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xlaser4j.hr.entity.RoleDO;
import com.xlaser4j.hr.entity.vo.SecurityMenuVO;
import com.xlaser4j.hr.service.IMenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * @package: com.xlaser4j.hr.security
 * @author: Elijah.D
 * @time: 2020/3/1 15:54
 * @description: 拦截请求, 从数据库获取请求对应的角色信息
 * @modified: Elijah.D
 */
@Component
public class CustomSecurityFilterMetadata implements FilterInvocationSecurityMetadataSource {
    private final IMenuService service;

    public CustomSecurityFilterMetadata(IMenuService service) {
        this.service = service;
    }

    /**
     * 核心逻辑处理: 拦截到url,根据url查询数据库中对应的数据,取出url对应的角色名(ROLE_..)
     * <p>
     * 注意这里会拦截所有请求,即使是config已经配置了loginPage路径,也会被拦截,因此需要要在config中忽略登陆页/login的路径
     * 让其返回请登录的json数据
     *
     * @param o {@link org.springframework.security.web.FilterInvocation}
     * @return 所需要的角色名
     * @throws IllegalArgumentException
     * @see CustomDecisionManager 真正决策对比请求与登陆用户角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        // 获取请求的url&数据库权限集合 TODO:权限列表缓存
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        List<SecurityMenuVO> menus = service.listMenuAndRoles();

        // ant匹配,如果数据库能匹配到,则返回对应所需要的角色,如果没有匹配到,则认为这个url无需权限控制任意访问,自定义标记,后续处理
        AntPathMatcher matcher = new AntPathMatcher();
        Optional<SecurityMenuVO> first = menus.stream().filter(menu -> matcher.match(menu.getUrl(), requestUrl)).findFirst();
        if (first.isPresent()) {
            String[] roleNames = first.get().getRoles().stream().map(RoleDO::getName).toArray(String[]::new);
            return SecurityConfig.createList(roleNames);
        } else {
            return SecurityConfig.createList("anyone_login");
        }
    }

    /**
     * 暂时用不到
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 支持所有
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

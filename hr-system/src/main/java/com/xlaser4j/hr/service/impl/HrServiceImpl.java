package com.xlaser4j.hr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.mapper.HrMapper;
import com.xlaser4j.hr.service.IHrService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, HrDO> implements IHrService {
    private final HrMapper mapper;

    public HrServiceImpl(HrMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 登陆验证
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HrDO hr = getOne(new LambdaQueryWrapper<HrDO>().eq(HrDO::getUsername, username));
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        // 获取用户角色信息,HrDO中会封装到Authorities中,便于对比是否拥有请求路径所需要的角色
        hr.setRoles(mapper.listRolesByHrId(hr.getId()));
        return hr;
    }
}

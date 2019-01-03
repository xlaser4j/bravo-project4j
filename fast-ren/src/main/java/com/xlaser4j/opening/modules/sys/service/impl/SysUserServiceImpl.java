package com.xlaser4j.opening.modules.sys.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.sys.entity.SysUserDO;
import com.xlaser4j.opening.modules.sys.mapper.SysUserMapper;
import com.xlaser4j.opening.modules.sys.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * service: 用户服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2018/10/11 19:43
 * @description: 用户服务
 * @modified: Elijah.D
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO> implements ISysUserService {
    /**
     * <p> 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return user 实体
     */
    @Override
    public SysUserDO getUserByName(String username) {
        return baseMapper.selectOne(new QueryWrapper<SysUserDO>().eq("username", username));
    }

    /**
     * <p> 获取用户权限id集合
     *
     * @param id 用户id
     * @return list 权限ids
     */
    @Override
    public List<Long> listMenuIdsByUserId(Long id) {
        return baseMapper.selectMenuIdsByUserId(id);
    }
}

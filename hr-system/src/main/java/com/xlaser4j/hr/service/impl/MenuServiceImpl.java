package com.xlaser4j.hr.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.entity.MenuDO;
import com.xlaser4j.hr.entity.vo.NavMenuVO;
import com.xlaser4j.hr.entity.vo.SecurityMenuVO;
import com.xlaser4j.hr.entity.vo.TreeVO;
import com.xlaser4j.hr.mapper.MenuMapper;
import com.xlaser4j.hr.service.IMenuService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements IMenuService {
    /**
     * 根据登陆用户id获取权限列表
     *
     * @return menus
     */
    @Override
    public List<NavMenuVO> listMenusByHrId() {
        HrDO hr = (HrDO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return baseMapper.listMenusByHrId(hr.getId());
    }

    /**
     * 获取数据库请求路径,对应的角色信息,用于获取当前请求所需要的角色信息
     *
     * @return menuAndRoles
     */
    @Override
    public List<SecurityMenuVO> listMenuAndRoles() {
        return baseMapper.listMenuAndRoles();
    }

    /**
     * 获取三级资源树,用于角色选择控制权限
     *
     * @return list
     */
    @Override
    public List<TreeVO> listMenuTrees() {
        return baseMapper.listMenuTrees();
    }
}

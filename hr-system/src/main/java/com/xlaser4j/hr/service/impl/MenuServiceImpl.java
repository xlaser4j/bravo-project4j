package com.xlaser4j.hr.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.entity.MenuDO;
import com.xlaser4j.hr.entity.vo.MenuVO;
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
    private final MenuMapper mapper;

    public MenuServiceImpl(MenuMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 根据登陆用户id获取权限列表
     *
     * @return menus
     */
    @Override
    public List<MenuVO> listMenusByHrId() {
        HrDO hr = (HrDO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return mapper.listMenusByHrId(hr.getId());
    }
}

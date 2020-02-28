package com.xlaser4j.hr.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.hr.entity.MenuDO;
import com.xlaser4j.hr.entity.vo.MenuVO;

/**
 * @package: com.xlaser4j.hr.service
 * @author: Elijah.D
 * @time: 2020/2/9 17:28
 * @description:
 * @modified: Elijah.D
 */
public interface IMenuService extends IService<MenuDO> {
    /**
     * 根据登陆用户id获取权限列表
     *
     * @return menus
     */
    List<MenuVO> listMenusByHrId();
}

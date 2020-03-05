package com.xlaser4j.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.hr.entity.MenuDO;
import com.xlaser4j.hr.entity.vo.MenuVO;
import com.xlaser4j.hr.entity.vo.NavMenuVO;
import com.xlaser4j.hr.entity.vo.SecurityMenuVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @package: com.xlaser4j.hr.mapper
 * @author: Elijah.D
 * @time: 2020/2/9 17:34
 * @description:
 * @modified: Elijah.D
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {
    /**
     * 根据登陆用户id获取权限列表
     *
     * @param id hrId
     * @return menus
     */
    List<NavMenuVO> listMenusByHrId(Integer id);

    /**
     * 获取数据库请求路径,对应的角色信息,用于获取当前请求所需要的角色信息
     *
     * @return menuAndRoles
     */
    List<SecurityMenuVO> listMenuAndRoles();

    /**
     * 获取三级资源树,用于角色选择控制权限
     *
     * @return list
     */
    List<MenuVO> listMenuTrees();
}

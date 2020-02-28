package com.xlaser4j.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.hr.entity.MenuDO;
import com.xlaser4j.hr.entity.vo.MenuVO;
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
    List<MenuVO> listMenusByHrId(Integer id);
}

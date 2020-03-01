package com.xlaser4j.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.hr.entity.HrDO;
import com.xlaser4j.hr.entity.RoleDO;

/**
 * @package: com.xlaser4j.hr.mapper
 * @author: Elijah.D
 * @time: 2020/2/9 17:34
 * @description:
 * @modified: Elijah.D
 */
public interface HrMapper extends BaseMapper<HrDO> {
    /**
     * 根据用户id,获取对应的角色信息
     *
     * @param id hrId
     * @return roles
     */
    List<RoleDO> listRolesByHrId(Integer id);
}

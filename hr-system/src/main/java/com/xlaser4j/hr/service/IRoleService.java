package com.xlaser4j.hr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.hr.entity.RoleDO;

/**
 * @package: com.xlaser4j.hr.service
 * @author: Elijah.D
 * @time: 2020/2/9 17:28
 * @description:
 * @modified: Elijah.D
 */
public interface IRoleService extends IService<RoleDO> {
    /**
     * 编辑角色的权限
     *
     * @param rid     角色id
     * @param menuIds 角色权限id
     * @return
     */
    boolean updateRoleMenusByRid(Integer rid, Integer[] menuIds);
}

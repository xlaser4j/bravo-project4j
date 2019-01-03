package com.xlaser4j.opening.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.modules.sys.entity.SysRoleDO;

/**
 * <p>
 * 服务类: 角色
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service
 * @author: Elijah.D
 * @time: 2018/10/11 19:40
 * @description: service角色相关
 * @modified: Elijah.D
 */
public interface ISysRoleService extends IService<SysRoleDO> {
    /**
     * 分页查询角色列表
     *
     * @param params 请求参数
     * @return page 分页查询内容
     */
    PageResponse listRoles(Map<String, Object> params);
}

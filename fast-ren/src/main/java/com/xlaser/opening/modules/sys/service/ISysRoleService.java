package com.xlaser.opening.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser.opening.common.PageResponse;
import com.xlaser.opening.modules.sys.entity.SysRoleDO;

/**
 * <p>
 * 服务类: 角色
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: service角色相关
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
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

package com.xlaser.opening.modules.sys.controller;

import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.xlaser.opening.common.ApiResponse;
import com.xlaser.opening.common.constants.ShiroConsts;
import com.xlaser.opening.common.PageResponse;
import com.xlaser.opening.modules.sys.service.ISysRoleMenuService;
import com.xlaser.opening.modules.sys.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 控制: role角色相关
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2019/1/3 && 10:17
 * @description: 角色控制器
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class SysRoleController extends AbstractController {
    private final ISysRoleService sysRoleService;

    private final ISysRoleMenuService sysRoleMenuService;

    /**
     * <p> 获取角色列表
     *
     * <p> 非-管理员{@code super_admin}只能看自己创建的角色信息
     *
     * @param params
     * @return
     */
    @GetMapping("/roles")
    public ApiResponse listRoles(Map<String, Object> params) {

        if (ObjectUtil.notEqual(ShiroConsts.SUPER_ADMIN, getUserId())) {
            params.put("createBy", getUsername());
        }

        PageResponse page = sysRoleService.listRoles(params);

        return ApiResponse.ofSuccess(page);
    }
}

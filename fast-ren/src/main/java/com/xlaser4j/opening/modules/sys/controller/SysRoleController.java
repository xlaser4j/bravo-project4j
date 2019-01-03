package com.xlaser4j.opening.modules.sys.controller;

import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.xlaser4j.opening.common.ApiResponse;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.common.constants.ShiroConsts;
import com.xlaser4j.opening.modules.sys.service.ISysRoleMenuService;
import com.xlaser4j.opening.modules.sys.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 控制: role角色相关
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: 2019/1/3 10:17
 * @description: 角色控制器
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

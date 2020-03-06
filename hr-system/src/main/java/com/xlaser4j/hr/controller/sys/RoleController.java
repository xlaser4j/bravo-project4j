package com.xlaser4j.hr.controller.sys;

import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.entity.MenuRoleDO;
import com.xlaser4j.hr.entity.RoleDO;
import com.xlaser4j.hr.entity.vo.TreeVO;
import com.xlaser4j.hr.service.IMenuRoleService;
import com.xlaser4j.hr.service.IMenuService;
import com.xlaser4j.hr.service.IRoleService;
import org.springframework.web.bind.annotation.*;

import static com.xlaser4j.hr.common.Status.*;

/**
 * @package: com.xlaser4j.hr.controller.sys
 * @author: Elijah.D
 * @time: 2020/3/5 19:26
 * @description: 权限相关
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/basic/roles")
public class RoleController {
    private final IRoleService roleService;

    private final IMenuService menuService;

    private final IMenuRoleService menuRoleService;

    public RoleController(IRoleService roleService, IMenuService menuService, IMenuRoleService menuRoleService) {
        this.roleService = roleService;
        this.menuService = menuService;
        this.menuRoleService = menuRoleService;
    }

    /**
     * 获取所有角色信息
     *
     * @return list
     */
    @GetMapping
    public ApiResponse<List<RoleDO>> listRoles() {
        return new ApiResponse<List<RoleDO>>().ofSuccess(roleService.list());
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @PostMapping
    public ApiResponse<String> saveRole(@RequestBody RoleDO role) {
        boolean flag = roleService.save(role);
        return flag ? new ApiResponse<String>().ofStatus(SAVE_SUCCESS) : new ApiResponse<String>().ofStatus(SAVE_FAIL);
    }

    /**
     * 删除角色信息
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRoleById(@PathVariable Integer id) {
        boolean flag = roleService.removeById(id);
        return flag ? new ApiResponse<String>().ofStatus(DELETE_SUCCESS) : new ApiResponse<String>().ofStatus(DELETE_FAIL);
    }

    /**
     * 获取三级资源树
     *
     * @return list
     */
    @GetMapping("/menuTree")
    public ApiResponse<List<TreeVO>> listMenuTrees() {
        return new ApiResponse<List<TreeVO>>().ofSuccess(menuService.listMenuTrees());
    }

    /**
     * 根据角色id,获取对应的权限资源id
     *
     * @return list
     */
    @GetMapping("/menuIds/{rid}")
    public ApiResponse<List<Integer>> listMenuIdsByRoleId(@PathVariable Integer rid) {
        return new ApiResponse<List<Integer>>().ofSuccess(menuRoleService.listObjs((Wrappers.<MenuRoleDO>lambdaQuery().eq(MenuRoleDO::getRid, rid)).select(MenuRoleDO::getMid), o -> (Integer)o));
    }

    /**
     * 编辑角色的权限
     *
     * @param rid     角色id
     * @param menuIds 角色权限id
     * @return
     */
    @PutMapping("/{rid}")
    public ApiResponse<String> updateRoleMenuById(@PathVariable Integer rid, @RequestBody Integer[] menuIds) {
        boolean flag = roleService.updateRoleMenusByRid(rid, menuIds);
        return flag ? new ApiResponse<String>().ofStatus(UPDATE_SUCCESS) : new ApiResponse<String>().ofStatus(UPDATE_FAIL);
    }
}

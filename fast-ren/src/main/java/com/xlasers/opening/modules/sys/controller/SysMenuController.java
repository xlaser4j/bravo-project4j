package com.xlasers.opening.modules.sys.controller;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xlasers.opening.common.ApiResponse;
import com.xlasers.opening.common.enums.Status;
import com.xlasers.opening.common.exception.FastRenException;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import com.xlasers.opening.modules.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.xlasers.opening.common.constants.ShiroConsts.MenuType.*;

/**
 * <p>
 * controller: 权限控制器
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2018/11/28 && 13:34
 * @description: 控制器, 权限
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys")
public class SysMenuController extends AbstractController {
    /**
     * 系统权限禁止删除,初始权限1-41
     */
    private static final Long MENU_MAX_ID = 41L;

    private final ISysMenuService menuService;

    @Autowired
    public SysMenuController(ISysMenuService sysMenuService) {
        menuService = sysMenuService;
    }

    /**
     * 校验参数: 新增,删除,修改
     *
     * @param menu 菜单实体
     */
    private void validateFrom(SysMenuDO menu) {

        // 菜单类型
        Integer type = menu.getType();

        // 上级菜单类型
        Integer parentType = menuService.getById(menu.getParentId()).getType();

        // 菜单校验: url不能为空, 父级类型只能为目录
        if (ObjectUtil.equal(type, MENU.getValue())) {

            if (StrUtil.isBlank(menu.getUrl())) {
                throw new FastRenException(Status.OPERATE_MENU_ERROR);
            }

            if (!ObjectUtil.equal(parentType, CATALOG.getValue())) {
                throw new FastRenException(Status.OPERATE_MENU_ERROR);
            }
        }

        // 按钮
        if (ObjectUtil.equal(type, BUTTON.getValue()) && !ObjectUtil.equal(parentType, 1)) {
            throw new FastRenException(Status.OPERATE_MENU_ERROR);
        }
    }

    /**
     * 获取导航栏
     *
     * @return api response
     */
    @GetMapping(value = "/nav")
    public ApiResponse getNav() {

        List<SysMenuDO> menus = menuService.listMenuByUserId(getUserId());

        return ApiResponse.ofSuccess(menus);
    }

    /**
     * 获取权限列表
     *
     * @return api response
     */
    @GetMapping(value = "/menus")
    public ApiResponse listMenus() {

        List<SysMenuDO> menus = menuService.list(null);
        for (SysMenuDO menu : menus) {
            SysMenuDO parentMenu = menuService.getById(menu.getParentId());
            if (parentMenu != null) {
                menu.setParentName(parentMenu.getName());
            }
        }

        return ApiResponse.ofSuccess(menus);
    }

    /**
     * 新增一个权限
     *
     * @param menu 菜单实体
     * @return api response
     */
    @PostMapping(value = "/menu")
    public ApiResponse saveMenu(@RequestBody SysMenuDO menu) {

        validateFrom(menu);

        menuService.save(menu);

        return ApiResponse.ofSuccess();
    }

    /**
     * 获取单个权限信息
     *
     * @param id 菜单主键
     * @return api response
     */
    @GetMapping(value = "/menu/{id}")
    public ApiResponse getMenu(@PathVariable Long id) {

        SysMenuDO menu = menuService.getById(id);

        return ApiResponse.ofSuccess(menu);
    }

    /**
     * 修改菜单
     *
     * @param menu 菜单实体
     * @return api response
     */
    @PutMapping(value = "/menu")
    public ApiResponse updateMenu(@RequestBody SysMenuDO menu) {

        validateFrom(menu);

        menuService.updateById(menu);

        return ApiResponse.ofSuccess();
    }

    /**
     * 删除权限信息
     *
     * @param id 菜单主键
     * @return api response
     */
    @DeleteMapping(value = "/menu/{id}")
    public ApiResponse deleteMenu(@PathVariable Long id) {

        // 系统权限禁止删除
        if (id > MENU_MAX_ID) {
            throw new FastRenException(Status.DELETE_SYS_MENU_ERROR);
        }

        // 下级菜单禁止删除
        List<SysMenuDO> subMenus = menuService.listSubMenuByParentId(id, null);
        if (subMenus.isEmpty()) {
            throw new FastRenException(Status.DELETE_PARENT_MENU_ERROR);
        }

        menuService.deleteById(id);

        return ApiResponse.ofSuccess();
    }

    /**
     * 新增/修改时的下拉菜单(不包含按钮类型)
     *
     * @return api response
     */
    @GetMapping(value = "/menus", params = "update")
    public ApiResponse listMenu() {

        List<SysMenuDO> menus = menuService.listMenuNotButton();

        return ApiResponse.ofSuccess(menus);
    }
}

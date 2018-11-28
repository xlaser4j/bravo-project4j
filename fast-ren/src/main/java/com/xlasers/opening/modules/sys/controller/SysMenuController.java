package com.xlasers.opening.modules.sys.controller;

import java.util.List;

import com.xlasers.opening.common.ApiResponse;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import com.xlasers.opening.modules.sys.service.IShiroService;
import com.xlasers.opening.modules.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * controller: 权限控制器
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.controller
 * @author: Elijah.D
 * @time: CreateAt 2018/11/28 && 13:34
 * @description: 控制器,权限
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {
    private final ISysMenuService menuService;

    private final IShiroService shiroService;

    @Autowired
    public SysMenuController(ISysMenuService sysMenuService, IShiroService shiroService) {
        this.menuService = sysMenuService;
        this.shiroService = shiroService;
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

}

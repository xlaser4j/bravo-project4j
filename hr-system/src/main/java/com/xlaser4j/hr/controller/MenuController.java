package com.xlaser4j.hr.controller;

import java.util.List;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.entity.vo.MenuVO;
import com.xlaser4j.hr.service.IMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.xlaser4j.hr.controller
 * @author: Elijah.D
 * @time: 2020/2/28 21:59
 * @description:
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/menus")
public class MenuController {
    private final IMenuService service;

    public MenuController(IMenuService service) {
        this.service = service;
    }

    /**
     * 根据用户id查询对应的权限菜单
     * <p>
     * 不可用传入的id,直接使用security中登陆的用户id
     *
     * @return menus
     */
    @GetMapping
    public ApiResponse<List<MenuVO>> listMenusByHrId() {
        return new ApiResponse<List<MenuVO>>().ofSuccess(service.listMenusByHrId());
    }
}

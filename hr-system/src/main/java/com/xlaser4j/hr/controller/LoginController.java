package com.xlaser4j.hr.controller;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.common.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.xlaser4j.hr.controller
 * @author: Elijah.D
 * @time: 2/19/2020 10:28 PM
 * @description:
 * @modified: Elijah.D
 */
@RestController
public class LoginController {
    /**
     * 前端后端分离,登陆页返回json
     *
     * @return msg
     */
    @GetMapping("/login")
    public ApiResponse<Object> login() {
        return new ApiResponse<>().ofStatus(Status.NO_LOGIN);
    }
}

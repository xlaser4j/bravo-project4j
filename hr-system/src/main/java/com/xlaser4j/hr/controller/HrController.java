package com.xlaser4j.hr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.xlaser4j.hr.controller
 * @author: Elijah.D
 * @time: 2020/2/9 22:34
 * @description:
 * @modified: Elijah.D
 */
@RestController("/hrs")
public class HrController {
    @GetMapping("/a")
    public String test() {
        return "Hello";
    }
}

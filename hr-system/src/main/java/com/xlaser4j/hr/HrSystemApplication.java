package com.xlaser4j.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @package: com.xlaser4j.hr
 * @author: Elijah.D
 * @time: 2020/2/9 17:30
 * @description: Start App
 * @modified: Elijah.D
 */
@EnableCaching
@MapperScan(basePackages = "com.xlaser4j.hr.mapper")
public class HrSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrSystemApplication.class, args);
    }
}

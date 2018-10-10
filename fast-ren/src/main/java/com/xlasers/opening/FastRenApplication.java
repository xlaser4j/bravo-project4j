package com.xlasers.opening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The type Fast ren application.
 *
 * @package: com.xlasers.opening
 * @author: Elijah.D
 * @time: CreateAt 2018/10/10 && 11:20
 * @description: spring-boot启动类
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@SpringBootApplication
public class FastRenApplication extends SpringBootServletInitializer {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(FastRenApplication.class, args);
    }

    /**
     * ??
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FastRenApplication.class);
    }
}

package com.xlaser4j.opening;

import com.xlaser4j.opening.datasource.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * <p>
 * app: spring启动类
 * </p>
 *
 * <p>exclude: 排除yml中数据库配置的autoconfig,避免没有配置数据源时自动读取,启动报错!
 *
 * @package: com.xlaser4j.opening
 * @author: Elijah.D
 * @time: 2018/10/10 11:20
 * @description: spring-boot启动类
 * @modified: Elijah.D
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DynamicDataSourceConfig.class})
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
     * <p> 继承SpringBootServletInitializer打成war包部署
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FastRenApplication.class);
    }
}

package com.xlaser.autoconfigure.config;

import cn.hutool.core.lang.Console;
import com.xlaser.autoconfigure.annotation.ConditionalOnHobby;
import com.xlaser.autoconfigure.annotation.HobbyType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @package: com.xlaser.autoconfigure.config
 * @author: Elijah.D
 * @time: 2019/10/27 10:38
 * @description: 测试符合条件的自动装配
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@Configuration
public class HobbyConfiguration {
    public HobbyConfiguration() {
        Console.log("\n=============>>【HobbyConfiguration】\n");
    }

    /**
     * 测试条件注入
     *
     * @return JsHobby
     */
    @Bean
    @ConditionalOnHobby(hobby = HobbyType.JS)
    JsHobby jsHobby() {
        return new JsHobby();
    }

    /**
     * 测试条件注入
     *
     * @return JavaHobby
     */
    @Bean
    @ConditionalOnHobby(hobby = HobbyType.JAVA)
    JavaHobby javaHobby() {
        return new JavaHobby();
    }
}

package com.xlaser.opening.config;

import java.util.Properties;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * config: 生成验证码配置类
 * </p>
 *
 * @package: com.xlaser.opening.config
 * @author: Elijah.D
 * @time: CreateAt 2018/11/7 && 11:13
 * @description: 生成验证码配置
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer() {
        Properties props = new Properties();
        props.put("kaptcha.border", "no");
        props.put("kaptcha.textproducer.font.color", "black");
        props.put("kaptcha.textproducer.char.space", "5");

        Config config = new Config(props);

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(config);

        return kaptcha;
    }
}

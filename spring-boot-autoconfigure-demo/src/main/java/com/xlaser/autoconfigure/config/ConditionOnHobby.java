package com.xlaser.autoconfigure.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @package: com.xlaser.autoconfigure.config
 * @author: Elijah.D
 * @time: 2019/10/27 16:23
 * @description: 测试Condition条件注入
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class ConditionOnHobby implements Condition {
    /**
     * 决定是否自动装配bean
     *
     * @param context  关于{@code Condition}的全局信息
     * @param metadata metadata of the {@link AnnotationMetadata class} or {@link MethodMetadata method} being checked
     * @return component  {@code true} can be registered,{@code false} can not be registered
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}

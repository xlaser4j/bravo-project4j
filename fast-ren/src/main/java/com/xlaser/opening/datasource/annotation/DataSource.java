package com.xlaser.opening.datasource.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * annotation: 数据源注解
 * </p>
 *
 * @package: com.xlaser.opening.datasource.annotation
 * @author: Elijah.D
 * @time: CreateAt 2018/11/7 && 15:26
 * @description: 多数据源: 根据注解切换
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * Name string.
     *
     * @return the string
     */
    String name() default "";
}
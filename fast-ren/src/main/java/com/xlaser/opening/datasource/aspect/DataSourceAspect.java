package com.xlaser.opening.datasource.aspect;

import java.lang.reflect.Method;

import com.xlaser.opening.datasource.DynamicDataSource;
import com.xlaser.opening.datasource.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import static com.xlaser.opening.common.constants.DataSourceNameConsts.FIRST;

/**
 * <p>
 * aspect: 数据源切面
 * </p>
 *
 * @package: com.xlaser.opening.datasource.aspect
 * @author: Elijah.D
 * @time: CreateAt 2018/11/7 && 15:44
 * @description: 根据切面动态切换数据源
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    /**
     * <p>切入带有@DataSource注解的方法
     *
     * @param point 切点信息
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("dataSourcePoint()")
    public static Object around(ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource source = method.getAnnotation(DataSource.class);
        if (source == null) {
            DynamicDataSource.setDataSource(FIRST);
            log.info("【DynamicDataSource】 set dataSource, name: {}", FIRST);
        } else {
            DynamicDataSource.setDataSource(source.name());
            log.info("【DynamicDataSource】 set dataSource, name: {}", source.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.info("【DynamicDataSource】 Clean the dataSource !");
        }
    }

    /**
     * <p>切点是带有注解@DataSource,表示拦截含有这个注解的方法
     */
    @Pointcut("@annotation(com.xlaser.opening.datasource.annotation.DataSource)")
    public void dataSourcePoint() {
        // 表示拦截含有这个注解的方法
    }

    /**
     * 数字越小优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}

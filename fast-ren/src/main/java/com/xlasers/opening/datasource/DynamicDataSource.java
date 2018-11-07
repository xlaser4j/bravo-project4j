package com.xlasers.opening.datasource;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 * dynamic: 动态数据源获取设置
 * </p>
 *
 * @package: com.xlasers.opening.datasource
 * @author: Elijah.D
 * @time: CreateAt 2018/11/7 && 15:33
 * @description: 默认配置获取相关
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * <p>ThreadLocal用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
     * 为每个线程创建一个【单独的变量副本】相当于线程的 private static类型变量。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * <p>决定使用哪个数据源之前需要把多个数据源的信息以及默认数据源信息配置好
     *
     * @param defaultTargetDataSource 默认数据源
     * @param targetDataSources       目标数据源
     */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        //配置bean属性,配置完所有bean属性之后调用,如果配置错误,抛出异常
        super.afterPropertiesSet();
    }

    /**
     * 获取数据源key
     *
     * @return key 数据源名称
     */
    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 设置数据源key
     *
     * @param dataSource 数据源名称
     */
    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    /**
     * 清空数据源key
     */
    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 决定使用哪个数据源
     *
     * @return key 返回数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
}
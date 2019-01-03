package com.xlaser.opening.datasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.xlaser.opening.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static com.xlaser.opening.common.constants.DataSourceNameConsts.FIRST;
import static com.xlaser.opening.common.constants.DataSourceNameConsts.SECOND;

/**
 * <p>
 * config: 动态数据源配置
 * </p>
 *
 * @package: com.xlaser.opening.datasource.config
 * @author: Elijah.D
 * @time: CreateAt 2018/11/7 && 15:40
 * @description: 数据源切换优先级相关
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Configuration
public class DynamicDataSourceConfig {
    /**
     * 数据源1
     *
     * @return data source
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源2
     *
     * @return data source
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源初始化
     *
     * @param firstDataSource  数据源1
     * @param secondDataSource 数据源2
     * @return dynamic data source
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {

        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(FIRST, firstDataSource);
        targetDataSources.put(SECOND, secondDataSource);

        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}

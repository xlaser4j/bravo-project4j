package com.xlaser4j.opening.datasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.xlaser4j.opening.common.constants.DataSourceNameConsts;
import com.xlaser4j.opening.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 * config: 动态数据源配置
 * </p>
 *
 * @package: com.xlaser4j.opening.datasource.config
 * @author: Elijah.D
 * @time: 2018/11/7 15:40
 * @description: 数据源切换优先级相关
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
        targetDataSources.put(DataSourceNameConsts.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNameConsts.SECOND, secondDataSource);

        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}

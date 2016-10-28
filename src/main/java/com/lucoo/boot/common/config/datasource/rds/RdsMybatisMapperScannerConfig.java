package com.lucoo.boot.common.config.datasource.rds;

import com.lucoo.boot.common.config.datasource.ads.AdsDataSourceConfig;
import com.lucoo.boot.common.mapper.CommonMapperDao;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by lucoo on 2016/10/28.
 */
@Configuration
//在AdsDataSourceConfig后面去装配
@AutoConfigureAfter(RdsDataSourceConfig.class)
public class RdsMybatisMapperScannerConfig {
    static final String PACKAGE = "com.lucoo.boot.dao.rds";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("rdsSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(PACKAGE);
        Properties properties = new Properties();
        //公共mapper不能放入PACKAGE
        properties.setProperty("mappers", CommonMapperDao.class.getName());
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}

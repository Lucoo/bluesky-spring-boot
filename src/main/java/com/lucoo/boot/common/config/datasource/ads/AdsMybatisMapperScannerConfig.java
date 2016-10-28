package com.lucoo.boot.common.config.datasource.ads;

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
@AutoConfigureAfter(AdsDataSourceConfig.class)
public class AdsMybatisMapperScannerConfig {
    static final String PACKAGE = "com.lucoo.boot.dao.ads";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("adsSqlSessionFactory");
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

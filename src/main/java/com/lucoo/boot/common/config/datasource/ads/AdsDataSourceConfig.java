package com.lucoo.boot.common.config.datasource.ads;

import com.github.pagehelper.PageHelper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lucoo on 2016/10/27.
 */
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:/config/dev/jdbc.properties"),
        @PropertySource(value = "classpath:/config/dev/mybatis.properties")
})
@MapperScan(basePackages = AdsDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "adsSqlSessionFactory")
public class AdsDataSourceConfig {
    static final String PACKAGE = "com.lucoo.boot.dao.ads";

    @Value("${datasource.w.url}")
    private String dbUrl;

    @Value("${datasource.w.username}")
    private String dbUser;

    @Value("${datasource.w.password}")
    private String dbPassword;

    @Value("${datasource.w.driverClassName}")
    private String driverClassName;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis.config-location}")
    private String configLocation;

    @Bean(name = "adsDataSource")
    public DataSource adsDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setUsername(dbUser);
        hikariConfig.setPassword(dbPassword);
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "adsTransactionManager")
    public DataSourceTransactionManager adsTransactionManager(@Qualifier("adsDataSource") DataSource adsDataSource) {
        return new DataSourceTransactionManager(adsDataSource);
    }

    @Bean(name = "adsSqlSessionFactory")
    public SqlSessionFactory adsSqlSessionFactory(@Qualifier("adsDataSource") DataSource adsDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(adsDataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sqlSessionFactoryBean.setMapperLocations
                (new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setConfigLocation
                (new PathMatchingResourcePatternResolver().getResource(configLocation));
        return sqlSessionFactoryBean.getObject();
    }
}

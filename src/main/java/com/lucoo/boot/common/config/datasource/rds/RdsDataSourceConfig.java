package com.lucoo.boot.common.config.datasource.rds;

import com.github.pagehelper.PageHelper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by lucoo on 2016/10/27.
 */
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:/config/dev/jdbc.properties"),
        @PropertySource(value = "classpath:/config/dev/mybatis.properties")
})
@MapperScan(basePackages = RdsDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "rdsSqlSessionFactory")
public class RdsDataSourceConfig {
    static final String PACKAGE = "com.lucoo.boot.dao.rds";

    @Value("${datasource.r.url}")
    private String dbUrl;

    @Value("${datasource.r.username}")
    private String dbUser;

    @Value("${datasource.r.password}")
    private String dbPassword;

    @Value("${datasource.w.driverClassName}")
    private String driverClassName;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis.config-location}")
    private String configLocation;

    @Bean(name = "rdsDataSource")
    @Primary
    public DataSource rdsDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setUsername(dbUser);
        hikariConfig.setPassword(dbPassword);
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "rdsTransactionManager")
    @Primary
    public DataSourceTransactionManager rdsTransactionManager(@Qualifier("rdsDataSource") DataSource rdsDataSource) {
        return new DataSourceTransactionManager(rdsDataSource);
    }

    @Bean(name = "rdsSqlSessionFactory")
    @Primary
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("rdsDataSource") DataSource rdsDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(rdsDataSource);
        sqlSessionFactoryBean.setMapperLocations
                (new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setConfigLocation
                (new PathMatchingResourcePatternResolver().getResource(configLocation));
        return sqlSessionFactoryBean.getObject();
    }
}

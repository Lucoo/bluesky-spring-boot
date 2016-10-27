package com.lucoo.boot.common.config.datasource.rds;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lucoo on 2016/10/27.
 */
@Configuration
@MapperScan(basePackages = RdsDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "rdsSqlSessionFactory")
public class RdsDataSourceConfig {
    static final String PACKAGE = "com.lucoo.boot.dao.rds";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean(name = "rdsDataSource")
    @Primary
    public DataSource rdsDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
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
        return sqlSessionFactoryBean.getObject();
    }
}

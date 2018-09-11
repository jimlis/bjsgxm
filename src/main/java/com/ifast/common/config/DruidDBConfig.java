package com.ifast.common.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by PrimaryKey on 17/2/4.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DruidDBConfig {
	private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);
	@Autowired(required = false)
	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired(required = false)
	@Value("${spring.datasource.username}")
	private String username;

	@Autowired(required = false)
	@Value("${spring.datasource.password}")
	private String password;

	@Autowired(required = false)
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	@Autowired(required = false)
	@Value("${spring.datasource.initialSize}")
	private int initialSize;

	@Autowired(required = false)
	@Value("${spring.datasource.minIdle}")
	private int minIdle;

	@Autowired(required = false)
	@Value("${spring.datasource.maxActive}")
	private int maxActive;

	@Autowired(required = false)
	@Value("${spring.datasource.maxWait}")
	private int maxWait;

	@Autowired(required = false)
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Autowired(required = false)
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Autowired(required = false)
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;

	@Autowired(required = false)
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;

	@Autowired(required = false)
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;

	@Autowired(required = false)
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;

	@Autowired(required = false)
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Autowired(required = false)
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Autowired(required = false)
	@Value("${spring.datasource.filters}")
	private String filters;

	@Autowired(required = false)
	@Value("{spring.datasource.connectionProperties}")
	private String connectionProperties;

	@Bean(initMethod = "init", destroyMethod = "close") // 声明其为Bean实例
	@Primary // 在同样的DataSource中，首先使用被标注的DataSource
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();
		if (StringUtils.isNotBlank(dbUrl)) {
			datasource.setUrl(dbUrl);
		}
		if (StringUtils.isNotBlank(username)) {
			datasource.setUsername(username);
		}

		if (StringUtils.isNotBlank(password)) {
			datasource.setPassword(password);
		}

		if (StringUtils.isNotBlank(driverClassName)) {
			datasource.setDriverClassName(driverClassName);
		}

		// configuration
		if (initialSize > 0) {
			datasource.setInitialSize(initialSize);
		}
		if (minIdle > 0) {
			datasource.setMinIdle(minIdle);
		}
		if (maxActive > 0) {
			datasource.setMaxActive(maxActive);
		}
		if (maxWait > 0) {
			datasource.setMaxWait(maxWait);
		}

		if (timeBetweenEvictionRunsMillis > 0) {
			datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		}
		if (minEvictableIdleTimeMillis > 0) {
			datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		}
		if (StringUtils.isNotBlank(validationQuery)) {
			datasource.setValidationQuery(validationQuery);
		}

		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		datasource.setPoolPreparedStatements(poolPreparedStatements);
		if (maxPoolPreparedStatementPerConnectionSize > 0) {
			datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		}
		try {
			if (StringUtils.isNotBlank(filters)) {
				datasource.setFilters(filters);
			}

		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		if (StringUtils.isNotBlank(connectionProperties)) {
			datasource.setConnectionProperties(connectionProperties);
		}

		return datasource;
	}

	// 要想使用@Value
	// 用${}占位符注入属性，这个bean是必须的，这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}

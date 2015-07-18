package edu.kwon.travelagent.fe.spring.config.profiledefault;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.kwon.travelagent.core.config.ConfigParam;
import edu.kwon.travelagent.core.config.PropertiesParam;

/**
 * Application Jpa Data Configuration
 * Declare beans of
 * - DataSource
 * - Entity Manager Factory: use
 * - Transaction Manager:
 * @author Bunlong Taing
 *
 * @since Jul 4, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
@Profile(ConfigParam.APP_PROFILE_DEFAULT)
@Configuration
@EnableJpaRepositories(ConfigParam.JPA_REPO_BASE_PACKAGE)			// Package of annotated class is used, if not specify base package. repository-impl-postfix = (default) Impl
@EnableTransactionManagement										// = <tx:annotation-driven />
@PropertySource(value = ConfigParam.APP_CONFIG_PROPERTIES, ignoreResourceNotFound = true)
@PropertySource(value = ConfigParam.APP_PROFILE_DEFAULT_PROPERTIES, ignoreResourceNotFound = false)
public class AppDataConfig {
	
	@Value(PropertiesParam.DATABASE_URL)
	private String databaseUrl;
	
	@Value(PropertiesParam.DATABASE_INITIAL_SIZE)
	private int initialSize;
	
	@Value(PropertiesParam.DATABASE_MAX_ACTIVE)
	private int maxActive;
	
	@Value(PropertiesParam.DATABASE_USERNAME)
	private String username;
	
	@Value(PropertiesParam.DATABASE_PASSWORD)
	private String password;
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setJpaProperties(hibernateProperties());
		factory.setPackagesToScan(ConfigParam.ENTITY_PACKAGE_TO_SCAN);
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
		dataSource.setUrl(databaseUrl);
		dataSource.setInitialSize(initialSize);			// Initial connection size
		dataSource.setMaxActive(maxActive);				// Maximum active connection
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
//			{
//				// JPA properties ...
//			}
//		};
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);
//		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform(PostgresPlusDialect.class.getName());
		return vendorAdapter;
	}
	
}

package com.springmvc.Config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springmvc.Common.Constant;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springmvc.Repositories"})
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		try {
			em.setDataSource(dataSource());
			em.setPersistenceUnitName("persistence-data");
			JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			em.setJpaVendorAdapter(vendorAdapter);
			em.setJpaProperties(additionalProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws Exception{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		try {
			transactionManager.setEntityManagerFactory(entityManagerFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionManager;
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName(Constant.DRIVER);
			dataSource.setUrl(Constant.URL);
			dataSource.setUsername(Constant.USERNAME);
			dataSource.setPassword(Constant.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	Properties additionalProperties() throws Exception{
		Properties properties = new Properties();
		try {
//			properties.setProperty("hibernate.hbm2ddl.auto", "create");
//			properties.setProperty("hibernate.hbm2ddl.auto", "update");
//			properties.setProperty("hibernate.hbm2ddl.auto", "none");
//			properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}

package com.exampleZone.SpringMVCJavaBased.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value={"classpath:dbconfig.properties"})
public class JPAConfigurations {

	@Autowired
	private Environment env;
	
	/**
	 * Used to define the connection property for connecting to physical DB
	 * 
	 * @return instance of Datasource
	 */
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.username"));
		return dataSource;
	}
	
	
	/**
	 * Provide the used JPA Vendor(i.e. the implementation ex: Hibernate)
	 * 
	 * @return the implementation class for the specific JPA vendor
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}
	
	/**
	 * Returning the required properties for JPA 
	 * 
	 * @return properties 
	 */
	private Properties jpaProperties()
	{
		Properties p  = new Properties();
		p.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		p.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		p.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		p.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		return p;
	}
	
	
	/**
	 * Configuring EntityManagerFactory with the requred JPA configurations 
	 * 
	 * @return instance of EntityManagerFactory
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityMangerFactory()
	{
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] {"com.exampleZone.SpringMVCJavaBased.model"});
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		return factoryBean;
	}
	
	/**
	 * NOT SURE WHY DO WE NEED THIS METHOD ,LOOK INTO IT !!!
	 * 
	 * 
	 * @param emf
	 * @return returns instance of TransactionManager
	 */
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
	

	
}

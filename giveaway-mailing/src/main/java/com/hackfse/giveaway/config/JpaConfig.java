package com.hackfse.giveaway.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Configuration
//@EnableAutoConfiguration
public class JpaConfig {
	
	//@Autowired
	//private Environment env;
	
	/*@Autowired
    private DataSource dataSource;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;*/
	
	/*@Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("db.driver"));
        dataSource.setUser(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setJdbcUrl(env.getProperty("db.url"));	       
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.min_size")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.max_size")));
        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("hibernate.c3p0.idle_test_period"))); 	        
        return dataSource;
    }*/
	
	/*@Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }


    *//**
     * Declare the JPA entity manager factory.
     *//*
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        try {
			entityManagerFactory.setDataSource(dataSource());
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));


        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }
    
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
*/
}

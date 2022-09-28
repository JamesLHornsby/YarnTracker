package com.megagiganto.ypTracker.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.megagiganto.ypTracker"})
@EnableTransactionManagement
public class AppContext {

//    @Autowired
//    private Environment environment;
//
//
//    @Bean
//    public SessionFactory getSessionFactory(DataSource dataSource) {
//    	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
//    	builder.addProperties(getHibernateProperties());
//    	builder.scanPackages("com.megagiganto.ypTracker");
//    	return builder.buildSessionFactory();
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.format_sql", "true");
//        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
//        properties.put("hibernate.hbm2ddl.auto", "create-drop");
//        return properties;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager(SessionFactory session) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(session);
//        //transactionManager.setSessionFactory(session);
//        return transactionManager;
//    }
}
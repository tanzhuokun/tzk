package com.mdkj.health;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HibernateConfig {


	@Bean("sessionFactory")
	public LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") DataSource dataSource){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.mdkj");
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		hibernateProperties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public PlatformTransactionManager txManager(@Qualifier("sessionFactory") SessionFactory sessionFactory){
		
		return new HibernateTransactionManager(sessionFactory);
	}

}
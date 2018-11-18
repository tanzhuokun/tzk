package com.mdkj.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("com.mdkj")
@EnableCaching
@PropertySource("classpath:web.properties")
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true)
public class HealthPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthPlatformApplication.class, args);
	}

}

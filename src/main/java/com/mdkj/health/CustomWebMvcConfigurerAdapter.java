package com.mdkj.health;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CustomWebMvcConfigurerAdapter implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/").setViewName("forward:/public/login.html");
	}
}

package com.mdkj.health.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * 描述:网站配置
 *
 * @type_name 类名:WebConfig
 * @project_name 项目:HealthPlatform
 */
@Component
@ConfigurationProperties(prefix="web")
public class WebConfig {

	private String domain;
	
	private String name;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

package com.mdkj.health.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * 描述:短信接口配置
 *
 * @type_name 类名:SmsConfig
 * @project_name 项目:HealthPlatform
 */
@Component
public class SmsConfig {

	@Value("${smco_apiname:123456}")
	private String apiname;
	
	@Value("${smco_password:123456}")
	private String password;
	
	@Value("${smco_apikey:123456}")
	private String apikey;

	public String getApiname() {
		return apiname;
	}

	public void setApiname(String apiname) {
		this.apiname = apiname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	
	
	
}

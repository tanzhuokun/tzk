package com.mdkj.health.service;

import org.springframework.stereotype.Service;

import com.mdkj.health.base.BaseService;
import com.mdkj.health.entity.SMS;


/**
 * 
 * 
 * 描述:短信业务
 *
 * @type_name 类名:SMSService
 * @project_name 项目:HealthPlatform
 */
@Service
public class SMSService extends BaseService<SMS>{

	public SMS findByPhone(String phoneNum,String key,String platform) {
		
		return (SMS) getSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE sms_phone=? AND sms_key=? AND sms_platform=? ")
				.setParameter(0, phoneNum)
				.setParameter(1, key)
				.setParameter(2, platform)
				.uniqueResult();
	}

}

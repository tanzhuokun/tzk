package com.mdkj.health.controller.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.sms.SMSVerifyService;
import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.base.SmsConfig;
import com.mdkj.health.captcha.CaptchaImageCreateController;
import com.mdkj.health.entity.SMS;


/**
 * 
 * 
 * 描述:短信验证
 *
 * @type_name 类名:SMSController
 * @project_name 项目:HealthPlatform
 */
@RestController
public class SMSController extends BaseController{

	@Resource
	private SmsConfig smsConfig;

	/**
	 * 注册获取短信验证码
	 * @param type 短信类型
	 * @param mobile
	 * @param svmi 平台类型
	 * @return
	 */
	@RequestMapping(value="/sms/{type}/get",method=RequestMethod.POST)
	public String getSMSRegCode(@PathVariable String type,String mobile,@RequestParam(defaultValue="Urban") String svmi,String randCode){

		try{
			String key="sms-send"+mobile+DataTransferUtil.getDate("yyyy-MM-dd");

			Cache smsCache = cacheManager.getCache("userCache");
			System.err.println("短信发送缓存:"+smsCache);
			ValueWrapper elem=smsCache.get(key);
			if(elem==null){
				smsCache.put(key, 1);
			}else{
				Integer daySendTime=(Integer) elem.get();
				smsCache.put(key, daySendTime+1);
			}

			Integer todaySend=(Integer) smsCache.get(key).get();
			if(todaySend<=10){
				if(CaptchaImageCreateController.static_checkKaptcha(getSession(), randCode)){
					return comSend(mobile, type,"您的检验码%code%，感谢您的使用【银结通】","",svmi);
				}else{
					return "验证码不匹配！";
				}
			}else{
				return "sendMore";
			}

		}catch (Exception e) {
			e.printStackTrace();
		}



		return RESULT_FAILED;
	}

	/**
	 * 公共短信发送
	 * @return
	 */
	public String comSend(String mobile,String key,String content,String member,String platForm){

		String code=DataTransferUtil.getSMSString(6);
		int time=5;
		content=content.replaceAll("%code%", code).replaceAll("%name%", member);
		//生成验证码
		//发送短信
		//存储验证码
		SMS exits_sms=smsService.findByPhone(mobile,key,platForm);
		System.err.println("短信存储:"+exits_sms);
		if(null!=smsConfig){
			String res=SMSVerifyService.sms_api(smsConfig.getApiname(), smsConfig.getPassword(), mobile, smsConfig.getApikey(), content);
			System.err.println(res);
			if(res.indexOf("success")>-1){
				if(null==exits_sms)
					exits_sms=new SMS();
				exits_sms.setCode(code);
				exits_sms.setPhone(mobile);
				exits_sms.setKey(key);
				exits_sms.setPlatForm(platForm);
				long dates=new Date().getTime();
				exits_sms.setTime(DataTransferUtil.dateTransferStr(dates, "yyyy-MM-dd HH:mm:ss"));

				exits_sms.setEndtime(DataTransferUtil.dateTransferStr(dates+(time*60*1000), "yyyy-MM-dd HH:mm:ss"));
				exits_sms.setCount(exits_sms.getCount()+1);
				smsService.saveOrUpdate(exits_sms);

				return RESULT_OK;
			}
		}
		return RESULT_FAILED;
	}

}

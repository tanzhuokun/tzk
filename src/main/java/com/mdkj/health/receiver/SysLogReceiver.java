package com.mdkj.health.receiver;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdkj.dev.sms.SMSVerifyService;
import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.SMS;
import com.mdkj.health.entity.SysLog;
import com.mdkj.health.service.SysLogService;

@Component
@RabbitListener(queues = "lyhTest1")
public class SysLogReceiver extends BaseController{
	
	
	@RabbitHandler
	public void logReceiver(Map<String, String> content) {
		SysLog sysLog = new SysLog();
		sysLog.setRemove(0);
		sysLog.setSerial(DataTransferUtil.getComSerial());
		sysLog.setSubTime(DataTransferUtil.getDate(DATE_FORMAT1));
		sysLog.setUpdateTime(DataTransferUtil.getDate(DATE_FORMAT1));
		sysLog.setClazz(null);
		sysLog.setLoglevel(String.valueOf(content.get("logLevel")));
		sysLog.setLogmsg(String.valueOf(content.get("logmsg")));
		sysLog.setMethod(String.valueOf(content.get("method")));
		sysLog.setOptype(null);
		sysLog.setRespones(1000);
		sysLog.setUserip("186.231.1.1");
		sysLog.setUsername(String.valueOf(content.get("username")));
		System.out.println(sysLog);
		System.out.println(sysLog.getRemove());
		sysLogService.save(sysLog);
		
		if (content.get("logmsg") == "ERROR") {
			String mobile = "15687064695";
			String apikey = "bb48a702743951efc90c7e9b461ab4f0";
			String contents = content.get("username") + "平台出现错误,请及时查看"+"【沧源智慧城管】";
			SMSVerifyService.sms_api("zhuisu", "chunchun1218", mobile, apikey, contents);
			SMS sms = new SMS();
			sms.setPhone(mobile);
			sms.setPlatForm(content.get("username"));
			sms.setTime(DataTransferUtil.getDate(DATE_FORMAT1));
		}
	}

}

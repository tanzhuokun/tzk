package com.mdkj.health.controller.cgibin;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.sms.SMSVerifyService;
import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.AdminAccount;

@RestController
@RequestMapping("/cgi-bin/")
public class SettingController extends BaseController{
	
	@RequestMapping(value = "/setting")
	public ModelAndView setting() {
		/*List<SysLog> syslog = sysLogService.findAll();
		m.addAttribute("SysLog", syslog);*/
		return myView("views/temp/setting");
	}
	
	@RequestMapping("/checkPhone.do")
	public int checkUsername(String phone){
		if (adminAccountService.findByPhone(phone) != null) {
			return 0;
		}else {
			return 1;			
		}
		
	}
	
	@RequestMapping("/setPhone.do")
	public int setPhone(String phone){
		System.out.println("phone:"+phone);
		String[] strings = phone.split(",");
		System.out.println(strings[0]);
		System.out.println(strings[1]);
		AdminAccount adminAccount = adminAccountService.findByPhone(strings[1]);
		if (adminAccount != null) {
				adminAccount.setPhone(strings[0]);
				adminAccountService.update(adminAccount);
				SMSVerifyService.sms_api("15912422417", "wys5116599", "15912422417", "be9340f5d4d5dc1f1649a957567b12ab", "短信校验码"+DataTransferUtil.getSMSString(6)+"【沧源智慧城管】");
				System.out.println(SMSVerifyService.sms_api("zhuisu", "chunchun1218", "15912422417", "bb48a702743951efc90c7e9b461ab4f0", "短信校验码"+DataTransferUtil.getSMSString(6)+"【沧源智慧城管】"));
			return 0;
		}else {
			return 1;
		}
	}
	
	
	
	

}

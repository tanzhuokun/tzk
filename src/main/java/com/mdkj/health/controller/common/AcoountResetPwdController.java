package com.mdkj.health.controller.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.Result;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.captcha.CaptchaImageCreateController;
import com.mdkj.health.entity.AdminAccount;
import com.mdkj.health.entity.SMS;

/**
 * 
 * 
 * 描述:管理员重置密码
 *
 * @type_name 类名:AcoountResetPwdController
 * @project_name 项目:HealthPlatform
 */
@RestController
@RequestMapping("/my")
public class AcoountResetPwdController extends BaseController{

	/**
	 * 验证用户身份
	 * @param phone
	 * @param randcode
	 * @return
	 */
	@PostMapping("/resetpwd/certification")
	public ModelAndView forwardFindPwdFind(String k,String randcode,String smscode,@RequestParam(defaultValue="0") Integer ktype){
		System.err.println("ktype="+ktype);
		String mobile=getCurAdmin().getPhone();
		String s_key=getSession().getAttribute("csrf_key").toString();
		if(s_key.equals(k)){
			boolean istrue=CaptchaImageCreateController.static_checkKaptcha(getSession(), randcode);
			if(istrue){
				SMS sms=smsService.findByPhone(mobile, "resetpwd", "Urban");
				if(sms!=null&&sms.getCode().equals(smscode)){
					String key=UUID.randomUUID().toString();
					getSession().setAttribute("account_truth", key);

					return myView("redirect:step02.html?truth="+key+"&type="+ktype);
				}
			}
		}

		return myView("redirect:step01.html");
	}


	/**
	 * 重置密码
	 * @param key
	 * @param password
	 * @param password2
	 * @return
	 */
	@PostMapping("/resetpwd/reset")
	public ModelAndView forwardResetPwdReset(String k,String password,String again_password,@RequestParam(defaultValue="0") Integer type){

		String s_key=getSession().getAttribute("account_truth").toString();
		System.err.println(s_key);
		if(s_key.equals(k)&&again_password.equals(password)){
			//修改密码
			try{

				AdminAccount adminAccount=adminAccountService.findBySerial(getCurAdmin().getSerial());
				if(adminAccount!=null){
					adminAccount.setPstrength(DataTransferUtil.checkPwdStrength(again_password));
					adminAccount.setPassword(DataTransferUtil.simpleMd5Hashpwd(password, adminAccount.getSalt(), SHIRO_HASH_ITERATIONS));
					adminAccountService.update(adminAccount);
					return myView("redirect:step03/success.html");
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return myView("redirect:step03/error.html");
	}

}

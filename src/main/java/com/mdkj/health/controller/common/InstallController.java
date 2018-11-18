package com.mdkj.health.controller.common;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.Result;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.AdminAccount;
/**
 * 
 * 
 * 描述:系统初始化
 *
 * @type_name 类名:InstallController
 * @project_name 项目:HealthPlatform
 */
@RestController
public class InstallController extends BaseController{


	/**
	 * 管理员账号
	 * @return
	 */
	@RequestMapping(value="sys/admin/install",method=RequestMethod.GET)
	public String installAdmin(){

		AdminAccount admin=new AdminAccount();
		admin.setMail("111111111@qq.com");
		admin.setLastIp(getRequestIP());
		admin.setAccountPic("http://www.baidu.com");
		admin.setLastLogin(DataTransferUtil.getDate(DATE_FORMAT1));
		admin.setAccount("ynzs2016");
		String salt=DataTransferUtil.getSalt();
		admin.setSalt(salt);
		String intpwd="123456";

		admin.setPassword(DataTransferUtil.simpleMd5Hashpwd(intpwd, salt, SHIRO_HASH_ITERATIONS));
		admin.setPhone("11111111111");
		admin.setRealName("默认");
		admin.setGender("男");
		admin.setBirth("2014年12月18日");
		admin.setSerial(DataTransferUtil.getComSerial());
		admin.setRegTime(DataTransferUtil.getDate(DATE_FORMAT1));
		admin.setSubTime(DataTransferUtil.getDate(DATE_FORMAT1));

		adminAccountService.save(admin);

		return RESULT_OK;
	}

}

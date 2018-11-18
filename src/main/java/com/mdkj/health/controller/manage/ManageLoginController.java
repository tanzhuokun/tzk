package com.mdkj.health.controller.manage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.health.base.BaseController;

/**
 * 
 * 
 * 描述:管理员登录模块
 *
 * @type_name 类名:ManageLoginController
 * @project_name 项目:HealthPlatform
 */
@RestController
@RequestMapping("/master")
public class ManageLoginController extends BaseController{

	/**
	 * 登录跳转
	 * @return
	 */
	@RequestMapping("/sign")
	public ModelAndView sign(){
		
		return myView("redirect:../cgi-bin/index");
	}
	
	
}

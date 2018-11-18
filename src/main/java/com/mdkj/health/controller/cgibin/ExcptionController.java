package com.mdkj.health.controller.cgibin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.health.base.BaseController;

@RestController
@RequestMapping("/cgi-bin/")
public class ExcptionController extends BaseController{
	
	@RequestMapping(value = "/ser")
	public ModelAndView excption() {
		/*List<SysLog> syslog = sysLogService.findAll();
		m.addAttribute("SysLog", syslog);*/
		return myView("views/temp/excption");
	}

}

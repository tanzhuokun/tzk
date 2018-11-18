package com.mdkj.health.controller.cgibin;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.LayerResult;
import com.mdkj.dev.utils.PageStaticUtil;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.Server;
import com.mdkj.health.entity.SysLog;

import freemarker.template.Template;

/**
 * 
 * 
 * 描述:首页
 *
 * @type_name 类名:IndexController
 * @project_name 项目:HealthPlatform
 */
@RestController
@RequestMapping("/cgi-bin/")
public class NoteController extends BaseController{
	
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/note")
	public ModelAndView note(){

		/**
		 * 向页面传递参数
		 * "页面参数名称","参数值"
		 * Object[] params={"page","/views/index.html","product","西红柿"};
		 * 
		 */
		Map<String, Object> paramDatas = new HashMap<>();
		paramDatas.put("name", "萌芽熊");
		PageStaticUtil.pageStatic(getRequest().getServletContext(), configuration, "views/page/index1.html", paramDatas, "/m/page/index1.html");

		Object[] params={"page","/views/index1.html"};

		return myView("views/temp/note",params);
	}


	
	
	
	

	
	
	
	
	
	
	
}

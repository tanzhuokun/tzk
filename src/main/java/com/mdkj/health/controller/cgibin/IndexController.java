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
public class IndexController extends BaseController{
	
	

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView index(){

		/**
		 * 向页面传递参数
		 * "页面参数名称","参数值"
		 * Object[] params={"page","/views/index.html","product","西红柿"};
		 * 
		 */
		Map<String, Object> paramDatas = new HashMap<>();
		paramDatas.put("name", "萌芽熊");
		PageStaticUtil.pageStatic(getRequest().getServletContext(), configuration, "views/page/index.html", paramDatas, "/m/page/index.html");

		Object[] params={"page","/views/index.html"};

		return myView("views/temp/index",params);
	}

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/index1")
	public ModelAndView index1(){

		/**
		 * 向页面传递参数
		 * "页面参数名称","参数值"
		 * Object[] params={"page","/views/index.html","product","西红柿"};
		 * 
		 */
		Map<String, Object> paramDatas = new HashMap<>();
		paramDatas.put("name", "萌芽熊");
		PageStaticUtil.pageStatic(getRequest().getServletContext(), configuration, "views/page/index1.html", paramDatas, "/m/page/index1.html");

		Object[] params={"page","/views/platform.html"};

		return myView("views/temp/platform",params);
	}


	@RequestMapping(value="/data")
	public ModelAndView data(){

		Object[] params={"page","/views/data/data1.html"};

		return myView("views/temp/index",params);
	}

	@RequestMapping(value="/countSysLog")
	public int countSysLog() {
		return sysLogService.countByCondition(null, null);
	}

	@RequestMapping(value="/findother")
	public Map<String, Object> findother() {
		LayerResult layerResult = new LayerResult();
		return layerResult.error(null, sysLogService.findAll());
	}
	
	@RequestMapping(value="/findlog")
	public List<String> findlog() {
		List<String> lists = new ArrayList<>();
		List<SysLog> list = sysLogService.findAll();
		for (SysLog sysLog : list) {
			String username = sysLog.getUsername();
			String loglevel = sysLog.getLoglevel();
			String subtime = sysLog.getSubTime();
			lists.add("平台名: "+username+" 日志等级: "+loglevel+" 时间: "+subtime);
		}
		Collections.reverse(lists);
		return lists;
	}
	
	
	public Map<String, Object> all(){
		List<SysLog> sysLog = sysLogService.findAll();
		List<Server> server = serverService.findAll();
		
		return null;
	}
	
	
	
	

	
	
	
	
	
	
	
}

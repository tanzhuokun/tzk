package com.mdkj.health.controller.cgibin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.LayerResult;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.Server;
import com.mdkj.health.entity.SysLog;

@RestController
@RequestMapping("/cgi-bin/")
public class LogController extends BaseController{
	
	@RequestMapping(value = "/log")
	public ModelAndView log(Model m) {
		/*List<SysLog> syslog = sysLogService.findAll();
		m.addAttribute("SysLog", syslog);*/
		return myView("views/temp/log");
	}
	
	@RequestMapping(value = "logCount")
	public List<Integer> logCount() {
		List<Integer> list = new ArrayList<>();
		String date = DataTransferUtil.getDate();
		int warn = sysLogService.countByLogLevelDate("WARN", date, null, null);
		int error = sysLogService.countByLogLevelDate("ERROR", date, null, null);
		int info = sysLogService.countByLogLevelDate("INFO", date, null, null);
		int debug = sysLogService.countByLogLevelDate("DEBUG", date, null, null);
		list.add(warn);
		list.add(error);
		list.add(info);
		list.add(debug);	
		return list;
	}
	
	@RequestMapping(value = "/titleLogName")
	public List<Object> titleLogName() {
		return sysLogService.distinctLog("method", null, null);
	}
	
	@RequestMapping(value = "titleLogCount")
	public List<Integer> titleLogCount() {
		List<Integer> counts = new ArrayList<>();
		List<Object> list = sysLogService.distinctLog("method", null, null);
		for (Object string : list) {
			int count = sysLogService.countByLogName("method", string, null, null);
			counts.add(count);
		}
		return counts;
	}
	
	@RequestMapping(value = "/logDetails")
	public Map<String, Object> logDetails() {
		List<SysLog> syslog = sysLogService.findAll();
		Collections.reverse(syslog);
		int count = sysLogService.countByCondition(null, null);
		LayerResult layerResult = new LayerResult();
		return layerResult.success(null, syslog, count);
	}
	
	@RequestMapping(value = "/logAll")
	public List<List<Object>> logAll() {
		List<List<Object>> list = new ArrayList<>();
		List<Object> object  = new ArrayList<>();
		List<SysLog> log = sysLogService.findAll();
		for (SysLog sysLog : log) {
			String date = sysLog.getSubTime();
			int count = sysLogService.countByLogDate(date.substring(0, 10), null, null);
			object.add(date);
			object.add(count);
		}
		
		for (int i = 0; i < object.size(); i+=2) {
			list.add(object.subList(i, i+2));
		}
		System.out.println(list);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

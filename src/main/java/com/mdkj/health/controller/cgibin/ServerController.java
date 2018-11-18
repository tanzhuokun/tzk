package com.mdkj.health.controller.cgibin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.utils.LayerResult;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.Pandect;
import com.mdkj.health.entity.Server;
import com.mdkj.health.entity.SysLog;

@RestController
@RequestMapping("/cgi-bin/")
public class ServerController extends BaseController{
	
	@RequestMapping(value = "/excption")
	public ModelAndView server(Model m) {
		int count = serverService.countByCondition(null, null);
		m.addAttribute("count", count);
		List<Server> servers = serverService.findAll();
		String ram = null;
		String hdd = null;
		String cpu = null;
		String rate = null;
		for (Server server : servers) {
			ram = server.getRam();
			hdd = server.getHdd();
			cpu = server.getCpu();
			rate = server.getRate();
		}
		m.addAttribute("ram", ram);
		m.addAttribute("hdd", hdd);
		m.addAttribute("cpu", cpu);
		m.addAttribute("rate", rate);
		/*List<SysLog> syslog = sysLogService.findAll();
		m.addAttribute("SysLog", syslog);*/
		return myView("views/temp/excption");

	}
	
	@RequestMapping("/serverLog")
	public List<String> serverLog(Model m) {
		List<String> ram = new ArrayList<>();
		List<Server> server = serverService.findAll();
		for (Server server2 : server) {
			ram.add(server2.getRam());
		}
		m.addAttribute("ramList", ram);
		System.out.println(server);
		return ram;
	}
	
	@RequestMapping("/serverDate")
	public List<String> serverDate() {
		List<Server> server = serverService.findAll();
		List<String> date = new ArrayList<>();
		for (Server server2 : server) {
			date.add(server2.getSubTime().substring(10));
		}
		return date;
	}
	
	@RequestMapping("/serverAll")
	public Map<String, Object> serverAll(){
		Map<String, Object> map = new HashMap<>();
		List<Server> server = serverService.findAll();
		LayerResult layerResult = new LayerResult();
		int count = serverService.countByCondition(null, null);
		return layerResult.success(null, server, count);
	}
	
	
	@RequestMapping("/all")
	public List<Object> all(){
		Pandect pandect = new Pandect();
		List<Object> list = sysLogService.distinctLog("username", null, null);
		List<Server> server = serverService.findAll();
		for (Server server2 : server) {
			pandect.setCpu(server2.getCpu());
			pandect.setDateTime(server2.getSubTime());
			pandect.setHdd(server2.getHdd());
			pandect.setRam(server2.getRam());
			pandect.setRate(server2.getRate());
		}
		for (Object object : list) {
			int count = sysLogService.countByLogName("username", object, null, null);
			pandect.setLogCount(count);
		}
		return null;
	}
	
	@RequestMapping("/selectRam")
	public List<List<Object>> objectAll() {
		List<List<Object>> list = new ArrayList<>();
		List<Object> object  = new ArrayList<>();
		List<Server> server = serverService.findAll();
		for (int i = 0; i < server.size(); i++) {
			Integer ram = Integer.parseInt(server.get(i).getRam());
			String date = server.get(i).getSubTime().substring(0, 10);
			object.add(0, date);
			object.add(1, ram);
			System.out.println(object);
		}
		for (int i = 0; i < object.size(); i+=2) {
			list.add(object.subList(i, i+2));
		}
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/selectHdd")
	public List<List<Object>> Hdd() {
		List<List<Object>> list = new ArrayList<>();
		List<Object> object  = new ArrayList<>();
		List<Server> server = serverService.findAll();
		for (int i = 0; i < server.size(); i++) {
			Integer hdd = Integer.parseInt(server.get(i).getHdd());
			String date = server.get(i).getSubTime().substring(0, 10);
			object.add(0, date);
			object.add(1, hdd);	
			System.out.println(object);
		}
		for (int i = 0; i < object.size(); i+=2) {
			list.add(object.subList(i, i+2));
		}
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/selectCpu")
	public List<List<Object>> selectCpu() {
		List<List<Object>> list = new ArrayList<>();
		List<Object> object  = new ArrayList<>();
		List<Server> server = serverService.findAll();
		for (int i = 0; i < server.size(); i++) {
			Integer cpu = Integer.parseInt(server.get(i).getCpu());
			String date = server.get(i).getSubTime().substring(0, 10);
			object.add(0, date);
			object.add(1, cpu);	
			System.out.println(cpu);
		}
		for (int i = 0; i < object.size(); i+=2) {
			list.add(object.subList(i, i+2));
		}
		System.out.println(list);
		return list;
	}
	
	
	
	
	
	
	
	

}

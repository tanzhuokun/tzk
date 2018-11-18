package com.mdkj.health.controller.cgibin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.PageStaticUtil;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.SysLog;

@RestController
@RequestMapping("/cgi-bin/")
public class PlatformController extends BaseController{

	@RequestMapping(value="/platform")
	public ModelAndView platform(){

		return myView("views/temp/platform");
	}
	
	
	
	/**
	 * 现在到前一天的所有日志数据
	 * @return
	 */
	@RequestMapping("timeLog")
	public List<SysLog> timeLog() {
		List<SysLog> log = new ArrayList<>();
		List<SysLog> list = sysLogService.findAll();
		String nowDate = DataTransferUtil.getDate(DATE_FORMAT1);
		String beforDate = DataTransferUtil.getbeforeDay(1, DATE_FORMAT1);
		Date date = new Date();
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long nowTime = simpleDateFormat.parse(nowDate).getTime();
			long beforTime = simpleDateFormat.parse(beforDate).getTime();
//			System.out.println(beforDate);
//			System.out.println(nowDate);
			for (SysLog sysLog : list) {
				String subDate = sysLog.getSubTime();
				//System.out.println(subDate);
				long subTime = simpleDateFormat.parse(subDate).getTime();
//				System.out.println(subTime);
				if ((nowTime - subTime) >= (nowTime - beforTime)) {
					date.setTime(subTime);
					String sate = simpleDateFormat.format(date);
//					System.out.println(sate);
					int num = Integer.parseInt(sysLog.getSubTime().substring(11, 13));
					log.add(sysLog);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		System.out.println(log);
		return log;
	}
	
	/**
	 * 查询每隔时段的日志总数量按每小时来计算
	 * @return
	 */
	@RequestMapping("/num")
	public List<Integer> num(){
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		List<SysLog> syslog = timeLog();
		int arr[] = new int[24];
		for (SysLog sysLog2 : syslog) {
			String num = sysLog2.getSubTime().substring(11, 13);
			System.out.println(num);
			if (num.equals("01")) {
				arr[0]++;
				map.put("1", arr[0]);
//				list.add(arr[0]);
			}
			if (num.equals("02")) {
				arr[1]++;
				map.put("2", arr[1]);
//				list.add(arr[1]);
			}
			if (num.equals("03")) {
				arr[2]++;
				map.put("3", arr[2]);
//				list.add(arr[2]);
			}
			if (num.equals("04")) {
				arr[3]++;
				map.put("4", arr[3]);
//				list.add(arr[3]);
			}
			if (num.equals("05")) {
				arr[4]++;
				map.put("5", arr[4]);
//				list.add(arr[4]);
			}
			if (num.equals("06")) {
				arr[5]++;
				map.put("6", arr[5]);
//				list.add(arr[5]);
			}
			if (num.equals("07")) {
				arr[6]++;
				map.put("7", arr[6]);
//				list.add(arr[6]);
			}
			if (num.equals("08")) {
				arr[7]++;
				map.put("8", arr[7]);
//				list.add(arr[7]);
			}
			if (num.equals("09")) {
				arr[8]++;
				map.put("9", arr[8]);
//				list.add(arr[8]);
			}
			if (num.equals("10")) {
				arr[9]++;
				map.put("10", arr[9]);
//				list.add(arr[9]);
			}
			if (num.equals("11")) {
				arr[10]++;
				map.put("11", arr[10]);
//				list.add(arr[10]);
			}
			if (num.equals("12")) {
				arr[11]++;
				map.put("12", arr[11]);
//				list.add(arr[11]);
			}
			if (num.equals("13")) {
				arr[12]++;
				map.put("13", arr[12]);
//				list.add(arr[12]);
			}
		
			if (num.equals("14")) {
				arr[13]++;
				map.put("14", arr[13]);
//				list.add(arr[13]);
			}
			if (num.equals("15")) {
				arr[14]++;
				map.put("15", arr[14]);
//				list.add(arr[14]);
			}
			if (num.equals("16")) {
				arr[15]++;
				map.put("16", arr[15]);
//				list.add(arr[15]);
			}
			if (num.equals("17")) {
				arr[16]++;
				map.put("17", arr[16]);
//				list.add(arr[16]);
			}
			if (num.equals("18")) {
				arr[17]++;
				map.put("18", arr[17]);
//				list.add(arr[17]);
			}
			if (num.equals("19")) {
				arr[18]++;
				map.put("19", arr[18]);
//				list.add(arr[18]);
			}
			if (num.equals("20")) {
				arr[19]++;
				map.put("20", arr[19]);
//				list.add(arr[19]);
			}
			if (num.equals("21")) {
				arr[20]++;
				map.put("21", arr[20]);
//				list.add(arr[20]);
			}
			if (num.equals("22")) {
				arr[21]++;
				map.put("22", arr[21]);
//				list.add(arr[21]);
			}
			if (num.equals("23")) {
				arr[22]++;
				map.put("23", arr[22]);
//				list.add(arr[22]);
			}
			if (num.equals("24")) {
				arr[23]++;
				map.put("24", arr[23]);
//				list.add(arr[23]);
			}
		}
		for (int i = 0; i < arr.length; i++) {		
			list.add(arr[i]);
		}
		
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/countLogLevel")
	public List<Integer> countLogLevel() {
		List<Integer> list = new ArrayList<>();
		int error = sysLogService.countByLogName("loglevel", "ERROR", null, null);
		int warn = sysLogService.countByLogName("loglevel", "WARN", null, null);
		int info = sysLogService.countByLogName("loglevel", "INFO", null, null);
		int debug = sysLogService.countByLogName("loglevel", "DEBUG", null, null);
		System.out.println(warn);
		list.add(error);
		list.add(warn);
		list.add(info);
		list.add(debug);
		return list;
	}
	
	
	
	
	
	
	
	

}

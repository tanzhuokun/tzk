package com.mdkj.dev.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mdkj.health.entity.SysLog;
/**
 * 
 * 
 * 描述:Layer表单插件数据
 *
 * @type_name 类名:LayerResult
 * @project_name 项目:HealthPlatform
 */
public class LayerResult {

	public static Map<String, Object> error(String message){
		Map<String, Object> res=new HashMap<>();
		res.put("code", 1);
		res.put("msg", message);
		res.put("count", 0);
		res.put("data", null);

		return res;
	}
	
	public static Map<String, Object> error(String message, List<SysLog> data){
		Map<String, Object> res=new HashMap<>();
		res.put("code", 0);
		res.put("msg", message);
		res.put("count", 0);
		res.put("data", data);

		return res;
	}


	public static <T> Map<String, Object> success(String message,List<T> datas,int counts){

		Map<String, Object> res=new HashMap<>();
		res.put("code", 0);
		res.put("msg", message);
		res.put("count", counts);
		res.put("data", datas);

		return res;
	}
}

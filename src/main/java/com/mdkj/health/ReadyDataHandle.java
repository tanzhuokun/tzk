package com.mdkj.health;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.mdkj.health.base.BaseController;

/**
 * 
 * 
 * 描述: 准备数据
 *
 * @type_name 类名:ReadyDataHandle
 * @project_name 项目:Hotel
 */
@Component
public class ReadyDataHandle extends BaseController implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//初始化
	}

}

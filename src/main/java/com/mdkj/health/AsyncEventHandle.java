package com.mdkj.health;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.mdkj.health.base.BaseController;

@Component
public class AsyncEventHandle extends BaseController{


	@Async
	@EventListener(classes={Object.class})
	public void readyRoomData(Object item){
		try{
			//异步处理
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.mdkj.health.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mdkj.dev.utils.QueryUtils;
import com.mdkj.health.base.BaseService;
import com.mdkj.health.entity.Server;

@Service
public class ServerService extends BaseService<Server>{
	
public List<Server> findByCondition(String starTime,String endTime,int cur,int maxsize){
		
		Map<String, Object> params = new HashMap<>();

		String sql=" FROM "+clazz.getSimpleName()+" WHERE isremove=0 ";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageQuery(getSession(), sql, params, cur, maxsize)
				.getResultList();
	}
	
	
	public int countByCondition(String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT COUNT(*) FROM tbl_server";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

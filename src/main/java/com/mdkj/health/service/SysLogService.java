package com.mdkj.health.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;
import org.springframework.stereotype.Service;

import com.mdkj.dev.utils.QueryUtils;
import com.mdkj.health.base.BaseService;
import com.mdkj.health.entity.SysLog;

@Service
public class SysLogService extends BaseService<SysLog>{

	public List<SysLog> findByCondition(String starTime,String endTime,int cur,int maxsize){
		
		Map<String, Object> params = new HashMap<>();

		String sql=" FROM "+clazz.getSimpleName()+" WHERE isremove=0 ";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageQuery(getSession(), sql, params, cur, maxsize)
				.getResultList();
	}
	
	
	public int countByCondition(String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT COUNT(*) FROM tbl_syslog WHERE isremove=0 ";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}
	
	public int countByLogName(String name, Object object, String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT COUNT(*) FROM tbl_syslog WHERE "+ name +"='"+object+"'";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}
	
	public int countByLogLevelDate(String logLevel,String date, String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT COUNT(*) FROM tbl_syslog WHERE loglevel='"+logLevel+"' AND subTime LIKE '%" + date + "%'";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}
	
	public List<Object> distinctLog(String distinctName, String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT DISTINCT " + distinctName + " FROM SysLog";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageQuery(getSession(), sql, params).getResultList();
	}
	
	public int countByLogDate(String date, String starTime,String endTime){

		Map<String, Object> params = new HashMap<>();

		String sql="SELECT COUNT(*) FROM tbl_syslog WHERE subTime LIKE '%" + date + "%'";

		sql=QueryUtils.timeNotNull(sql, params, "starTime", "endTime", starTime, endTime, " AND subtime>=? AND subtime<=? ");

		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}
	
	
	
	
	
	
	
	
	
	
	


}

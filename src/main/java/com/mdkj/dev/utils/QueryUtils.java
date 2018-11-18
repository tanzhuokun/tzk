package com.mdkj.dev.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.BooleanType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;
/**
 * 
 * 
 * 描述:查询工具
 *
 * @type_name 类名:QueryUtils
 * @project_name 项目:HealthPlatform
 */
public class QueryUtils {

	public static String stringNotNull(String sql,Map<String,Object> params,String key,String value,
			String express){

		if(DataTransferUtil.stringNotNull(value)){
			sql+=" "+express+" ";
			if(express.toUpperCase().indexOf("LIKE") >0){
				params.put(key,"%"+value+"%");
			}else{
				params.put(key,value);
			}
		}
		return sql;
	}

	public static String integerNotNull(String sql,Map<String,Object> params,String key,Integer value,
			String express){

		if(value!=null){
			sql+=" "+express+" ";
			params.put(key, value);
		}

		return sql;
	}

	public static String longNotNull(String sql,Map<String,Object> params,String key,Long value,
			String express){

		if(value!=null){
			sql+=" "+express+" ";
			params.put(key, value);
		}

		return sql;
	}


	public static String booleanNotNull(String sql,Map<String,Object> params,String key,Boolean value,
			String express){

		if(value!=null){
			sql+=" "+express+" ";
			params.put(key, value);
		}

		return sql;
	}

	public static String timeNotNull(String sql,Map<String,Object> params,String key1,String key2,String starTime,String endTime,
			String express){

		if(DataTransferUtil.TimeNotNull(starTime, endTime)){
			sql+=" "+express+" ";
			params.put(key1, starTime);
			params.put(key1, endTime);
		}

		return sql;
	}


	public static Query setParameters(Query query,Map<String, Object> values) {
		values.entrySet().forEach(item->{
			query.setParameter( item.getKey() ,item.getValue());
		});

		return query;
	}


	/**
	 * 查询列表
	 * @param session
	 * @param sql
	 * @param params
	 * @param types
	 * @param cur
	 * @param maxsize
	 * @return
	 */
	public static Query packageQuery(Session session,String sql,Map<String, Object> params,Integer cur,int maxsize){

		Query query=session.createQuery(sql);
		query=setParameters(query, params);

		if(cur!=null){
			query=query.setFirstResult(cur).setMaxResults(maxsize);
		}

		return query;
	}

	public static Query packageQuery(Session session,String sql,Map<String, Object> params){

		Query query=session.createQuery(sql);
		query=setParameters(query, params);
		return query;
	}


	public static int packageCountQuery(JdbcTemplate jdbcTemplate,String sql,Map<String, Object> params){

		Integer res=null;
		try{
			List<Object> mparams = new ArrayList<>();
			params.entrySet().forEach(item->{
				mparams.add(item.getValue());
			});
			res=jdbcTemplate.queryForObject(sql, mparams.toArray(),Integer.class);
		}catch (Exception e) {
			// TODO: handle exception
		}

		return res!=null?res:0;

	}


	public static int packageCountQuery(JdbcTemplate jdbcTemplate,String sql){

		Integer res=null;
		try{
			res=jdbcTemplate.queryForObject(sql,Integer.class);
		}catch (Exception e) {
			// TODO: handle exception
		}

		return res!=null?res:0;

	}
}

package com.mdkj.health.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseService<T> {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplate;
	}

	protected Class<T> clazz = null;


	public BaseService() {

		// 通过反射获取T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}


	//=================================== 华丽的风格线 ===================================//

	public T findBySerial(String serial) {
		// TODO Auto-generated method stub
		if (serial == null) {
			return null;
		} else {
			return (T) getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE serial=?")
					.setParameter(0, serial)
					.uniqueResult();
		}
	}

	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(entity);
	}

	public Integer save(T entity) {
		// TODO Auto-generated method stub
		return (Integer) getSession().save(entity);
	}

	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSession().delete(entity);
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

	public T getById(Integer id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	public T findBySystem() {
		// TODO Auto-generated method stub
		return (T) getSession().createQuery("FROM "+clazz.getSimpleName()).uniqueResult();
	}

	public int maxIdentity(String pk) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("SELECT MAX("+pk+") FROM "+clazz.getSimpleName());
		Number number=(Number) query.uniqueResult();
		if(null==number) return 1;

		return number.intValue()+1;
	}

	public List<T> findAll() {
		// 注意空格！
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

}

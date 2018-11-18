package com.mdkj.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mdkj.health.entity.supper.BaseEntity;

/**
 * 
 * 
 * 描述:系统日志
 *
 * @type_name 类名:SysLog
 * @project_name 项目:HealthPlatform
 */
@Entity
@Table(name="tbl_syslog")
public class SysLog extends BaseEntity{

	
	@Column(name="ss_id", length=10)
	private Integer ss_id;
	/**
	 * 对象缓存服务
	 */
	@Column(name="clazz",length=50)
	private String clazz;

	/**
	 * 方法
	 */
	@Column(name="method",length=255)
	private String method;

	/**
	 * 日志的级别
	 */
	@Column(name="loglevel",length=255)
	private String loglevel;

	/**
	 * 日志信息
	 */
	@Column(name="logmsg",length=255)
	private String logmsg;
	
	/**
	 * 用户名
	 */
	@Column(name="username",length=50)
	private String username;

	/**
	 * 操作类型
	 */
	@Column(name="optype",length=50)
	private String optype;

	/**
	 * 用户ip地址
	 */
	@Column(name="userip",length=50)
	private String userip;
	
	/**
	 * 响应回应
	 */
	@Column(name="respones")
	private long respones;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}
	
	public long getRespones() {
		return respones;
	}

	public void setRespones(long respones) {
		this.respones = respones;
	}

	public Integer getSs_id() {
		return ss_id;
	}

	public void setSs_id(Integer ss_id) {
		this.ss_id = ss_id;
	}

	@Override
	public String toString() {
		return "SysLog [ss_id=" + ss_id + ", clazz=" + clazz + ", method=" + method + ", loglevel=" + loglevel
				+ ", logmsg=" + logmsg + ", username=" + username + ", optype=" + optype + ", userip=" + userip
				+ ", respones=" + respones + ", subTime=" + subTime + ", updateTime=" + updateTime + "]";
	}

	
	
	

	
	
}

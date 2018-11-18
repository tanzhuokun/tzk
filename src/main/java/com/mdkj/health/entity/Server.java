package com.mdkj.health.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mdkj.health.entity.supper.BaseEntity;

@Entity
@Table(name="tbl_server")
public class Server implements Serializable{
	
	private static final long serialVersionUID = 5897871065886443010L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="s_id")
	private Integer id;
	
	@Column(name="ss_id", length=10)
	private Integer ss_id;
	
	@Column(name="subTime", length=50)
	private String subTime;
	
	@Column(name="serverName", length=50)
	private String serverName;

	@Column(name="ram", length=50)
	private String ram;
	
	@Column(name="hdd", length=50)
	private String hdd;
	
	@Column(name="cpu", length=50)
	private String cpu;
	
	@Column(name="rate", length=50)
	private String rate;
	
	@Column(name="profiler", length=50)
	private String profiler;


	public Integer getSs_id() {
		return ss_id;
	}

	public void setSs_id(Integer ss_id) {
		this.ss_id = ss_id;
	}

	public String getProfiler() {
		return profiler;
	}

	public void setProfiler(String profiler) {
		this.profiler = profiler;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubTime() {
		return subTime;
	}

	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public String toString() {
		return "Server [id=" + id + ", ss_id=" + ss_id + ", subTime=" + subTime + ", serverName=" + serverName
				+ ", ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + ", rate=" + rate + ", profiler=" + profiler + "]";
	}

	

	

	
	
	
	
	
	
	
	
	
	
	

	
	
}

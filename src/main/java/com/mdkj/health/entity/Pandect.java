package com.mdkj.health.entity;

import java.io.Serializable;

public class Pandect implements Serializable{

	private static final long serialVersionUID = -7841304025120733655L;
	
	private String userName;
	private String dateTime;
	private int logCount;
	private String ram;
	private String hdd;
	private String rate;
	private String cpu;
	private String run;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getLogCount() {
		return logCount;
	}
	public void setLogCount(int logCount) {
		this.logCount = logCount;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRun() {
		return run;
	}
	public void setRun(String run) {
		this.run = run;
	}
	@Override
	public String toString() {
		return "Pandect [userName=" + userName + ", dateTime=" + dateTime + ", logCount=" + logCount + ", ram=" + ram
				+ ", hdd=" + hdd + ", rate=" + rate + ", cpu=" + cpu + ", run=" + run + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

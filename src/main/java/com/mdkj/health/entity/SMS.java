package com.mdkj.health.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

/**
 * 
 * 
 * 描述:短信认证
 *
 * @type_name 类名:SMS
 * @project_name 项目:HealthPlatform
 */
@Entity
@Table(name="tbl_sms")
public class SMS implements Serializable{

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	/**
	 * key值
	 */
	@Column(name="sms_key")
	private String key;
	
	/**
	 * 手机号
	 */
	@Column(name="sms_phone",length=11)
	private String phone;
	
	/**
	 * 验证码
	 */
	@Column(name="sms_code",length=6)
	private String code;
	
	/**
	 * 验证时间
	 */
	@Column(name="sms_time",length=20)
	private String time;
	
	/**
	 * 过期时间
	 */
	@Column(name="sms_endtime",length=20)
	private String endtime;
	
	/**
	 * 验证次数
	 */
	@Column(name="sms_count")
	private int count;
	
	/**
	 * 所属平台
	 */
	@Column(name="sms_platform")
	private String platForm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPlatForm() {
		return platForm;
	}

	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}
	

	
}

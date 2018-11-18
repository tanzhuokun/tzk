package com.mdkj.health.entity.supper;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * 
 * 
 * 描述:省市区联动
 *
 * @type_name 类名:CityLinkage
 * @project_name 项目:HealthPlatform
 */
@MappedSuperclass
public class CityLinkage extends BaseEntity{
	
	/**
	 * 省份
	 */
	@Column(name="province",columnDefinition="varchar(100)  comment '省份'")
	private String province;
	
	/**
	 * 市区
	 */
	@Column(name="city",columnDefinition="varchar(100) comment '市区'")
	private String city;
	
	/**
	 * 县/区
	 */
	@Column(name="county",columnDefinition="varchar(100) comment '县'")
	private String county;
	
	/**
	 * 地区
	 */
	@Column(name="region",columnDefinition="varchar(200) comment '地区（省市县区）'")
	private String region;

	/**
	 * 详细地址
	 */
	@Column(name="address",columnDefinition="varchar(200) comment '详细地址'")
	private String address;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
}

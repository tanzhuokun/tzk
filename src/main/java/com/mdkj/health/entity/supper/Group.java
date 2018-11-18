package com.mdkj.health.entity.supper;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * 
 * 描述:分类
 *
 * @type_name 类名:Group
 * @project_name 项目:HealthPlatform
 */
@MappedSuperclass
public class Group extends BaseEntity implements Serializable{

	/**
	 * 分类名称
	 */
	@Column(name="name",columnDefinition="varchar(30) not null comment '分类名称'") 
	private String name;//分类名称


	/**
	 * 分类别名
	 */
	@Column(name="alias",columnDefinition="varchar(30)  comment '分类别名'") 
	private String alias;//分类别名（静态文件位置）
	
	/**
	 * 分类排序
	 */
	@Column(name="orde",columnDefinition="int(11) not null default 0 comment '分类排序(0-999)'")//分类排序
	private int order;

	/**
	 * 分类描述
	 */
	@Column(name="description",columnDefinition="varchar(255) comment '分类描述'")//分类描述
	private String description;
	
	/**
	 * 分类类型
	 * 参数说明
	 * 0:系统 
	 * 1:自定义(暂时用1)
	 * 
	 */
	@Column(name="type",columnDefinition="int(2) not null default 0 comment '分类类型:0、系统;1、自定义'") 
	private int type;//分类类型：0系统 1自定义
	
	/**
	 * 父类编号
	 */
	@Column(name="parentids",columnDefinition="longtext comment '所属父类编号（父类1-父类2-父类3）'")
	public String parentIds;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
